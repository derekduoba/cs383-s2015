import java.util.*;
import java.util.Random;
import java.lang.Math;

public class Driver{

    //PriorityQueue<Candidate> fitnessHeap;
    Random random;
    int generationCount = 1;

	static boolean checkResult(Candidate obj){
		if( (-(Math.pow(2, (obj.x - 3750))) + (570 * obj.x) - 
			 2 * (Math.pow(2, (obj.y - 5000))) + (1500 * obj.y)) >= 9999975){
			System.out.println("You Win!!\n" + "X = " + obj.x + " Y = " + obj.y + " Generation = " generationCount); 
			return true;
		}else{
			return false;
		}
	}

    /*
    // we might not need this method
    static int determineFitness(Candidate currentCandidate) {
    
            // determine + set a candidate's fitness score
                   

            // add the current candidate to the fitness heap
    
    }
    */

    static void performSelection(Candidate currentCandidate, int index) {
        Math random = new Random();
        int n = (100 - index); // This ends up being the element's position
        int m = random.nextInt(100);

        //100e^-((x/45.7)^2.35) -> this function will provide a better distribution
        if ((n+m) <= 100) {
            // pair with m + n
            performCrossover(currentCandidate, fitnessList.get(100 - (m+n));
        } else {
            // pair with neighbor
            if (i < 99) {
                performCrossover(currentCandidate, fitnessList.get(i + 1);
            } else {
                performCrossover(currentCandidate, fitnessList.get(1); // started from the bottom now we here
            }
        }

    }

    static void performCrossover(Candidate parentOne, Candidate parentTwo) {
        Candidate childOne;
        Candidate childTwo;

        // make babies
        
        // mutate babies
        mutateChild(childOne);
        mutateChild(childTwo);

        // add mutated babies to uniqueCandidate
        
    }

    static void mutateChild(Candidate currentChild) {
        
        // add a random number between -50 and 50
        int mutateValue = random.nextInt(100) - 50;
        int choice = random.nextInt(1);
        if (choice) {
            currentChild.x += mutateValue;
        } else {
            currentChild.y += mutateValue;
        }
    }

	public static void main(String[] args){
		Candidate uniqueCandidate[] = new Candidate[100]; 
		ArrayList<Candidate> fitnessList[] = new ArrayList<Candidate>(100);
        //fitnessHeap = new PriorityQueue<Candidate>(100);

        /*int iterations = 1;*/
		
        int i = 0, j = 1, xMax1 = 0, xMax2 = 0, yMax1 = 0, yMax2 = 0;
        //random = new Random();

		// it may be of use to need something to handle duplicates (in order to vary the population better)
		for(int x = 0; x < 100; x++){
			uniqueCandidate[x] = new Candidate();
		}

		while(true){
			
            for(int x = 0; x < 99; x++){
				
                //Checks to see if solution is found
				if(checkResult(uniqueCandidate[x])) { break; }
				
                //Add elements to the fitness list too!
                fitnessList.add(uniqueCandidate[x]);
                uniqueCandidate[x] = null;

			}
			
            while (i < 99) {
                performCrossover();
            }

            //i handles odd parents
			//j handles even parents
            /*
            while(i < 50){
				//variables to be used in this loop
				xMax1 = uniqueCandidate[i].x;
                yMax1 = uniqueCandidate[i].y;
				xMax2 = uniqueCandidate[j].x; 
                yMax2 = uniqueCandidate[j].y;

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
            */
		}
	}
}
