public class mcKellipsMain2 {
	public static void main(String[] args) {
		System.out.println("Hello accountants...");
		bankAccount account = new bankAccount(1122, 20000.0);
		bankAccount.setAnnualInterestRate(4.5);
		
		bankAccount.withdraw(2500.0);

	}

}

// define the class bankAccount (note that Account is taken with java 8.)
// this has the data id and balance so far.
class bankAccount{

	// Implement the class here
	int id; // your account id
	double balance; // your account balance
	double annualInterestRate; // your account 

	/** Construct an account with a default balance and id*/
	bankAccount(){
		id = 0;
		balance = 0;
	}

	void setAnnualInterestRate(double newAnnualInterestRate) {
		// TODO Auto-generated method stub
		annualInterestRate = newAnnualInterestRate;
		
	}

	/** construct an account with a specified id and balance. */
	bankAccount(int newId, double newBalance){
		id = newId;
		balance = newBalance;
	}
}