import java.util.Scanner;
public class Exercise6_8 {
	public static void main(String[] args) {
		/* This code is meant to prompt the user what option 
		 * between three they wish to have and then do calculations
		 * depending on which option was given.
		 * 
		 * The first option is converting Fahrenheit to Celsius.
		 * The second option is converting Celsius to Fahrenheit.
		 * The last option is giving a chart of both C and F 
		 * from 0 to X with X being what the user input prior.
		 */
		
		//Establishing Scanner input
		Scanner input = new Scanner(System.in);
		
		//Prompts user to give selection and declares variables for calculation
	    System.out.println("Are you converting fahrenheit to celsius (1) " +
	    				"\nor celsius to fahrenheit (2) or would you like a chart? (3): ");
	    int selection = input.nextInt();
	    System.out.println("Please input the degree you want to use " + 
				"\n(For the chart, range's lowest value is always 0):");
	    double degree = input.nextDouble();
	    
	    selectionOptionCalculation(selection, degree);
	}
	public static void selectionOptionCalculation(int selection, double degree) {
		
		if (selection == 1) {
			
			conversionF2C(degree);	
		} 
		else if (selection == 2) {
			
			conversionC2F(degree);
		}
		else if (selection == 3) {
			
			conversionChart(degree);
		}
		
	}
	private static void conversionF2C(double degree) {
		
		
		
		Scanner input;
		double fahrenheit = degree;
		double celsius = (5.0 / 9) * (fahrenheit - 32);
		
		System.out.println("The converted degree in celsius is: " + celsius);
	}
	public static void conversionC2F(double degree) {
		
		
		
		Scanner input;
		double celsius = degree;
		double fahrenheit = (9.0 / 5) * celsius + 32;
		
		System.out.println("The converted degree in Fahrenheit is: " + fahrenheit);
	}
	public static void conversionChart(double degree) {
		
		printRange(degree);
        
	}
	public static void printRange(double degree) {
		
	   System.out.println("C | F");
		
	   Scanner input;
	   int countCel = 0;
	   double fahrenheit;
	   
	   while (countCel <= degree) 
	   {
		  fahrenheit = (9.0 / 5) * countCel + 32;
	      System.out.println(countCel + " | " + fahrenheit);
	      countCel++; 
	   }
	}
}
