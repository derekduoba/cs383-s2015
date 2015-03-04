import java.util.*;
import java.util.Random;
import java.lang.Math;

public class Driver{

    PriorityQueue<Candidate> fitnessHeap;

    /*
	static boolean compareObj(Candidate obj){
		//temporarily 5,000,000; will eventually be ~10,000,000 - 25
		if( (-(Math.pow(2, (obj.x - 3750))) + (570 * obj.x) - 
			 2 * (Math.pow(2, (obj.y - 5000))) + (1500 * obj.y)) >= 5000000){
			System.out.println("You Win!!\n" + "X = " + obj.x + " Y = " + obj.y); 
			return true;
		}else{
			return false;
		}
	}
    */

    static int determineFitness(Candidate currentCandidate) {
    
            // determine + set a candidate's fitness score
            
            // add the current candidate to the fitness heap
    
    }

    static void performSelection(Candidate currentCandidate) {

        int n = 1;
        if ((n+m) <= 100) {
            // pair with index m + n
        } else {
            // pair with neighbor
        }

        // performCrossover();

    }

    static void performCrossover(Candidate parentOne, Candidate parentTwo) {

        // make babies
        
        // mutate babies

        // add mutated babies to uniqueCandidate
    }

    static void mutateChild(Candidate currentChild) {
        
        // add a random number between -50 and 50
        
    }

	public static void main(String[] args){
		Candidate uniqueCandidate[] = new Candidate[100];
		/*int iterations = 1;*/
		int i = 0, j = 1, xMax1 = 0, xMax2 = 0, yMax1 = 0, yMax2 = 0;
		Random math = new Random();

		//initializing population_0
		//need something to handle duplicates
		for(int x = 0; x < 100; x++){
			uniqueCandidate[x] = new Candidate();
		}

		while(true){
			for(int x = 0; x < 100; x++){
				//Checks to see if solution is found
				if(compareObj(uniqueCandidate[x])){break;}
				//Add elements to max_heap too!
			}
			//i handles odd parents
			//j handles even parents
			while(i < 50){
				//variables to be used in this loop
				xMax1 = uniqueCandidate[i].x; yMax1 = uniqueCandidate[i].y;
				xMax2 = uniqueCandidate[j].x; yMax2 = uniqueCandidate[i].y;

				if(xMax1 > xMax2){
					if(yMax1 > yMax2){
						uniqueCandidate[i] = new Candidate(xMax1, yMax1);
						uniqueCandidate[j] = ((xMax1 + yMax2) > (xMax2 + yMax1)) ? new Candidate(xMax1, yMax2) : new Candidate(xMax2, yMax1);
					}else{
						uniqueCandidate[i] = new Candidate(xMax1, yMax1);
						if(yMax1 > yMax2){
							uniqueCandidate[i] = new Candidate(xMax1, yMax2);
							uniqueCandidate[j] = ((xMax1 + yMax1) > (xMax2 + yMax2)) ? new Candidate(xMax1, yMax1) : new Candidate(xMax2, yMax2);		
						}
					}
				}else{
					if(yMax1 > yMax2){
						uniqueCandidate[i] = new Candidate(xMax2, yMax1);
			            uniqueCandidate[j] = ((xMax2 + yMax2) > (xMax1 + yMax1)) ? new Candidate(xMax2, yMax2) : new Candidate(xMax1, yMax1);
					}else{
						uniqueCandidate[j] = new Candidate(xMax2, yMax2);
						uniqueCandidate[j] = ((xMax2 + yMax1) > (xMax1 + yMax2)) ? new Candidate(xMax2, yMax1) : new Candidate(xMax1, yMax2);
					}
				}
				//increment by two to only deal with odd/even parents
				i += 2; j += 2;
			}
		}
	}
}
