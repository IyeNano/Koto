
//********************************************************************
//  MonetaryCoinDriver.java       Author: Lewis/Loftus
// MonetaryCoinDriver==> MonetaryCoin === >   Coin  
//  Solution to Programming Project 9.1 
//********************************************************************

/* Code taken from inziladun here: http://www.programmingforums.org/post247609.html
 * Code edited for the sake of personal use. All original code is not mine.
 */
import java.util.Random;

public class MonetaryCoinDriver {

	static double sum;
	
	private static Random gen;
	
	public static void main(String [] args) {
		Random r = new Random();
		//double sum;
		int [] value = { 1, 2, 3, 4, 5, 6, 7, 8};

		for (int j = 0; j < value.length; j++){

			sum+=value[j];}
		System.out.println("\t" + sum);
		int y, j;
		MonetaryCoin [] coins = new MonetaryCoin[10];
		for (j = 0; j < coins.length; j++) {
			y = Math.abs(r.nextInt()) % value.length;
			coins [j] = new MonetaryCoin(value[y]);
		}
		
		for (j = 0; j < coins.length; j++)
			System.out.println("\t" + coins [j]);
		System.out.println("\n" + coins[0]
				+ " before flipping is "
				+ coins[0].getValue());
		System.out.println("after flipping is " + coins[0].getValue()); //Print out the value of the coin after flipping 

	}
}