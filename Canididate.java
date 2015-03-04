import java.util.Random;

public class Canidate{

	//You are welcome Derek.
	public int x;
	public int y;

	Canidate(){
		generateTuple();
	}

	Canidate(int x, int y){
		this.x = x;
		this.y = y;
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
	}

}