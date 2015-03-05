import java.util.Random;
import java.lang.Comparable;

public class Candidate implements Comparable<Candidate> {

	//You are welcome Derek.
	public int x;
	public int y;
    public double score;

	Candidate(){
		generateTuple();
	}

	Candidate(int x, int y){
		this.x = x;
		this.y = y;
        this.score = -(Math.pow(2, (x - 3750))) + (570 * x) - 2 * (Math.pow(2, (y - 5000))) + (1500 * y);
	}

	public void generateTuple(){
		Random math = new Random();
		this.x = math.nextInt(10001);
		this.y = math.nextInt(10001);
		while((this.x + this.y) > 10000){
			//Generates # beween 0 -> 10,000 (exclusive so not including 10,001)
			this.x = math.nextInt(10001);
			this.y = math.nextInt(10001);
		}
        this.score = -(Math.pow(2, (x - 3750))) + (570 * x) - 2 * (Math.pow(2, (y - 5000))) + (1500 * y);
	}

    public int compareTo(Candidate otherCandidate) {
        int result = -1;
        if (this.score < otherCandidate.score) {
            result = 1;
        } else if (this.score == otherCandidate.score) {
            result = 0;
        }
        return result;
    }

}
