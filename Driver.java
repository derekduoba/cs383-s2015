import java.util.*;
import java.util.Random;
import java.lang.Math;

public class Driver{

    static ArrayList<Candidate> candidateList;
    static ArrayList<Candidate> fitnessList;
    static Random random;
    static int generationCount;
    static double highScore;

	static boolean checkResult(Candidate obj){
        double score = -(Math.pow(2, (obj.x - 3750))) + (570 * obj.x) - 2 * (Math.pow(2, (obj.y - 5000))) + (1500 * obj.y);
        if (score > highScore) {
            highScore = score;
        }
        if( score >= 9999975){
			System.out.println("You Win!!\n" + "X = " + obj.x + " Y = " + obj.y + " Score = " + score + " Generation = " + generationCount); 
            return true;
		}else{
            return false;
		}
	}

    static void performSelection(Candidate currentCandidate, int index) {
        int n = (100 - index); // This ends up being the element's position
        int m = random.nextInt(100);
        //100e^-((x/45.7)^2.35) -> this function will provide a better distribution
        if ((n+m) <= 100) {
            // pair with m + n
            performCrossover(currentCandidate, fitnessList.get(100 - (m+n)));
        } else {
            // pair with neighbor
            if (index < fitnessList.size() - 1) {
                performCrossover(currentCandidate, fitnessList.get(index + 1));
            } else {
                performCrossover(currentCandidate, fitnessList.get(0)); // started from the bottom now we here
            }
        }
    }


    static void performCrossover(Candidate parentOne, Candidate parentTwo) {
        Candidate child;
        int xMax1 = parentOne.x;
        int xMax2 = parentTwo.x;
        int yMax1 = parentOne.y;
        int yMax2 = parentTwo.y;
        PriorityQueue<Candidate> childQueue = new PriorityQueue<Candidate>();
        childQueue.add(new Candidate(xMax1, yMax1));
        childQueue.add(new Candidate(xMax1, yMax2));
        childQueue.add(new Candidate(xMax2, yMax1));
        childQueue.add(new Candidate(xMax2, yMax2));

        child = childQueue.poll();
        while ((child.x + child.y) > 10000) {
            child = childQueue.poll();
            if ((child.x + child.y) > 10000 && childQueue.isEmpty()) {
                return;
            }
        }
        // mutate baby
        mutateChild(child);
        // add mutated baby to uniqueCandidate
        candidateList.add(child);
    }

    static void mutateChild(Candidate currentChild) {
        int x = currentChild.x;
        int y = currentChild.y;
        int combination = 10001;
        while (combination > 10000) {
            x = currentChild.x;
            y = currentChild.y;    
            // add a random number between -500 and 500
            int mutateValue = random.nextInt(1000) - 500;
            boolean choice = random.nextBoolean();
            if (choice) {
                x += mutateValue;
            } else {
                y += mutateValue;
            }
            combination = x + y;
        }
        
        currentChild.x = x;
        currentChild.y = y;
    }

	public static void main(String[] args){
		candidateList = new ArrayList<Candidate>(100);
        fitnessList = new ArrayList<Candidate>(100);
        generationCount = 1;
        random = new Random();
        highScore = 0;
        int i = 0, j = 1, xMax1 = 0, xMax2 = 0, yMax1 = 0, yMax2 = 0;
        
		// Initialize the initial population
		for(int x = 0; x < 100; x++){
            candidateList.add(new Candidate());
		}

		while(true){
			
            System.out.println("GENERATION NUMBER: " + generationCount);
            System.out.println("HIGH SCORE: " + highScore);
            
            for(int x = 0; x < 99; x++){
				
                //Checks to see if solution is found
				if(checkResult(candidateList.get(x))) { 
                    System.exit(0);    
                }
			}
            fitnessList.addAll(candidateList);
            candidateList.clear();
            i = 0;
            while (i < 99) {
                performSelection(fitnessList.get(i), i);
                i++;
            }
            fitnessList.clear();  
            generationCount++;
		}
	}
}
