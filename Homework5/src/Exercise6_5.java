import java.util.Scanner;
public class Exercise6_5 {
	public static void main(String[] args) {
		/*This is a chunk of code meant to take three user-input numbers
		 * and sort them in ascending order. However, the kicker is that
		 * the calculations to sort it have to be in a custom method.
		 */
		
		//Establishing Scanner input
		Scanner input = new Scanner(System.in);
		
		//Prompts user to enter three numbers
	    System.out.print("Enter three numbers: ");
	    
	    //Declaring variables 
		double num1 = input.nextDouble();
	    double num2 = input.nextDouble();
	    double num3 = input.nextDouble();
	    
	    //Initializing the custom method
		displaySortedNumbers(num1, num2, num3);
	}


	public static void displaySortedNumbers(double num1, double num2, double num3) {
		
			//Sorting numbers
		    if (num1 > num2) {
		      double temp = num1;
		      num1 = num2;
		      num2 = temp;
		    }

		    if (num2 > num3) {
		      double temp = num2;
		      num2 = num3;
		      num3 = temp;
		    }

		    if (num1 > num2) {
		      double temp = num1;
		      num1 = num2;
		      num2 = temp;
		    }
		    
		    //Prints results
		    System.out.println("The sorted numbers are: "
				      + num1 + " " + num2 + " " + num3);
		    
		  }	
}
