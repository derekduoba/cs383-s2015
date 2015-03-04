import java.util.*;
import java.util.Random;
import java.lang.Math;

public class Driver{

	static boolean compareObj(Canidate obj){
		//temporarily 5,000,000; will eventually be ~10,000,000 - 25
		if( (-(Math.pow(2, (obj.x - 3750))) + (570 * obj.x) - 
			 2 * (Math.pow(2, (obj.y - 5000))) + (1500 * obj.y)) >= 5000000){
			System.out.println("You Win!!\n" + "X = " + obj.x + " Y = " + obj.y); 
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args){
		Canidate uniqueCanidate[] = new Canidate[100];
		/*int iterations = 1;*/
		int i = 0, j = 1, xMax1 = 0, xMax2 = 0, yMax1 = 0, yMax2 = 0;
		Random math = new Random();

		//initializing population_0
		//need something to handle duplicates
		for(int x = 0; x < 100; x++){
			uniqueCanidate[x] = new Canidate();
		}

		while(true){
			for(int x = 0; x < 100; x++){
				//Checks to see if solution is found
				if(compareObj(uniqueCanidate[x])){break;}
				//Add elements to max_heap too!
			}
			//i handles odd parents
			//j handles even parents
			while(i < 50){
				//variables to be used in this loop
				xMax1 = uniqueCanidate[i].x; yMax1 = uniqueCanidate[i].y;
				xMax2 = uniqueCanidate[j].x; yMax2 = uniqueCanidate[i].y;

				if(xMax1 > xMax2){
					if(yMax1 > yMax2){
						uniqueCanidate[i] = new Canidate(xMax1, yMax1);
						((xMax1 + yMax2) > (xMax2 + yMax1)) ? 
							uniqueCanidate[j] = new Canidate(xMax1, yMax2) : 
							uniqueCanidate[j] = new Canidate(xMax2, yMax1);
					}else{
						uniqueCanidate[i] = new Canidate(xMax1, yMax1);
						if(yMax1 > yMax2){
							uniqueCanidate[i].x = new Canidate(xMax1, yMax2);
							((xMax1 + yMax1) > (xMax2 + yMax2)) ? 
								uniqueCanidate[j] = new Canidate(xMax1, yMax1) :
								uniqueCanidate[j] = new Canidate(xMax2, yMax2);		
						}
					}
				}else{
					if(yMax1 > yMax2){
						uniqueCanidate[i] = new Canidate(xMax2, yMax1);
						((xMax2 + yMax2) > (xMax1 + yMax1)) ?
							uniqueCanidate[j] = new Canidate(xMax2, yMax2) :
							uniqueCanidate[j] = new Canidate(xMax1, yMax1);
					}else{
						uniqueCanidate[j] = new Canidate(xMax2, yMax2);
						((xMax2 + yMax1) > (xMax1 + yMax2)) ?
							uniqueCanidate[j] = new Canidate(xMax2, yMax1) :
							uniqueCanidate[j] = new Canidate(xMax1, yMax2);
					}
				}
				//increment by two to only deal with odd/even parents
				i += 2; j += 2;
			}
		}
	}
}
