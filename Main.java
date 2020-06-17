package Bank;

import java.util.Scanner;

public class Main {
	
	double accNo, deposit, withdraw, currentBal = 0, futureBal, intAmt, totIntAmt;
	String user, firstName, lastName, accType;
	int in, type, yrs;
	float interest;
	static Main call;
	
	Scanner s = new Scanner(System.in);
	
	//Main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		call = new Main();
		System.out.println("******WELCOME TO MONEY BANK******");
		call.createNewAccount();
		
	}
	//Main Menu
	public void mainMenu() {
		
		System.out.println("\n***Press 1 to Deposit money***\n"					
				+ "***Press 2 to Withdraw money***\n"							
				+ "***Press 3 to Check balance***\n"							
				+ "***Press 4 to get Account Details***\n"
				+ "***Press 5 to Calculate Interest***\n"						
				+ "***Press 0 to Exit***");
		in = s.nextInt();
		
		switch(in) {
		case 1: deposit();
				break;
		case 2: withdraw();
				break;
		case 3: balance();
				break;
		case 4: accDetails();
				break;
		case 5: calculateInterest();
				break;
		case 0: exit();
				break;
		default: System.out.println("Invalid input!\n"
				+ "Try again");
				mainMenu();
		}
		
	}
	//Calculate Interest
	private void calculateInterest() {
		// TODO Auto-generated method stub
		
		futureBal = currentBal;
		System.out.println("\n***Your Current balance is Rs." + currentBal + "***");
		System.out.println(">>>No of Years: ");
		yrs = s.nextInt();
		
		for(int i = 0;i < yrs; i++) {
			intAmt = (double) (futureBal *(interest / 100));
			totIntAmt = totIntAmt + intAmt;
			futureBal = (double) (futureBal + (futureBal *(interest / 100)));
		}
		System.out.println("***Total Interest is Rs." + totIntAmt + "***");
		System.out.println("***Total balance at end of term is Rs." + futureBal + "***");
		mainMenu();
		
	}
	//Details of current Account
	private void accDetails() {
		// TODO Auto-generated method stub
		System.out.println("***Account Holder's name: " + user + "***");
		System.out.println("***Your Account type is " + accType + "***");
		mainMenu();
				
		}
	//Withdrawing Money
	private void withdraw() {
		// TODO Auto-generated method stub
		
		System.out.println("***Your Current balance is Rs." + currentBal + "***");
		System.out.println(">>>Enter the amount of money to be withdrawn: ");
		withdraw = s.nextLong();
		if(withdraw < currentBal) {
			currentBal = currentBal - withdraw;
			balance();
		}
		else {
			System.out.println("Insufficient Balance");
			mainMenu();
		}
		
	}
	//Creating a new Account
	private void createNewAccount() {
		// TODO Auto-generated method stub
		
		System.out.println("\n>>>Enter your first name: ");
		firstName = s.next();
		System.out.println(">>>Enter your last name: ");
		lastName = s.next();
		user = firstName.concat(" ").concat(lastName);
		System.out.println(">>>Please select your Account type-\n\n"
				+ "***Press 1 for Savings Account***\n"
				+ "***Press 2 for Current Account***\n"
				+ "***Press 3 for Fixed Deposit***");
		type = s.nextInt();
		
		switch(type) {
		case 1: accType = "Savings";
				interest = 4.0f;
				break;
		case 2: accType = "Current";
				interest = 3.0f;
				break;
		case 3: accType = "Fixed";
				interest = 7.5f;
				break;
		default: System.out.println("Invalid input!\n"
				+ "Try again");
				mainMenu();
		}
		
		deposit();
		
	}
	//Depositing Money
	private void deposit() {
		// TODO Auto-generated method stub
		
		System.out.println("\n>>>Enter the amount of money to be added: ");
		deposit = s.nextLong();
		currentBal = currentBal + deposit;
		balance();
		
	}
	//Get Account Balance
	private void balance() {
		// TODO Auto-generated method stub
		
		System.out.println("\n***Your Current balance is Rs." + currentBal + "***");
		mainMenu();
		
	}
	//Exit Program
	private void exit() {
		
		System.exit(0);
		
	}
}
