class Account {
	private double balance;

	// Constructor to initialize the balance
	public Account(double balance) {
		this.balance = balance;
	}

	// Getter method to retrieve the balance
	public double getBalance() {
		return balance;
	}

	// Method to deposit funds into the account
	public void deposit(double amount) {
		System.out.println("Deposit: $" + amount);
		balance += amount;
		System.out.println("Current balance after deposit: $" + balance);
	}

	// Method to withdraw funds from the account
	public void withdraw(double amount) {
		System.out.println("Withdrawal: $" + amount);
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Current balance after withdrawal: $" + balance);
		} else
			System.out.println("Insufficient funds.");
	}
}

class SavingsAccount extends Account {
	private double interestRate;

	// Constructor to initialize balance and interest rate, using the superclass constructor
	public SavingsAccount(double balance, double interestRate) {
		super(balance);
		this.interestRate = interestRate;
	}

	// Getter method to retrieve the interest rate
	public double getInterestRate() {
		return interestRate;
	}

	// Method to calculate and display interest earned
	public void calculateInterest() {
		System.out.println("Interest Earned: $" + (interestRate * getBalance()));
	}
}

class CheckingAccount extends Account {
	private int overdraftLimit;

	// Constructor to initialize balance and overdraft limit, using the superclass constructor
	public CheckingAccount(double balance, int overdraftLimit) {
		super(balance);
		this.overdraftLimit = overdraftLimit;
	}

	// Getter method to retrieve the overdraft limit
	public int getOverdraftLimit() {
		return overdraftLimit;
	}

	// Overridden withdraw method to consider overdraft limit
	public void withdraw(double amount) {
		double availableFunds = getBalance() + overdraftLimit;
		if (amount <= availableFunds)
			super.withdraw(amount);
		else
			System.out.println("Insufficient funds.");
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		// Create a SavingsAccount object and perform operations
		SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
		savingsAccount.deposit(500);
		savingsAccount.calculateInterest();

		System.out.println();

		// Create a CheckingAccount object and perform operations
		CheckingAccount checkingAccount = new CheckingAccount(2000, 500);
		checkingAccount.deposit(1000);
		checkingAccount.withdraw(2500);
	}
}
