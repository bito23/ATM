package ro.jademy;

import java.util.Scanner;

public class Service {

	Login login = new Login();
	Users userlogat = new Users();

	Scanner keyboard = new Scanner(System.in);

	boolean flag = false;

	// Initiation...
	public void initOp() {
		System.out.println("Loading...");
	}

	// Methods for input
	public int userInputInt() {
		int userInput = keyboard.nextInt();
		return userInput;
	}

	public String userInputString() {
		String userInput = keyboard.next();
		return userInput;
	}

	public String userInputNextLineSingle() {
		String userInput = keyboard.nextLine();
		return userInput;
	}

	public String userInputNextLine() {
		keyboard.nextLine();
		String userInput = keyboard.nextLine();
		return userInput;
	}

	public double userInputDouble() {
		double userInput = keyboard.nextDouble();
		return userInput;
	}

	// Account for ADMIN
	public void accountAdmin() {

		Users accountAdmin = new Users();
		accountAdmin.setUser("admin");
		accountAdmin.setPassword("1234");
		accountAdmin.setFullname("Admin ATM");
		accountAdmin.setBalance(0);
		accountAdmin.setEnable(true);
		ATM.allUsers.add(accountAdmin);
	}

	// Home Screen
	public void showHomeScreen() {

		System.out.println("\nWelcome to My Bank!");
		System.out.println("(1) Login");
		System.out.println("(2) Register");
	}

	// Menu
	public void userOp() {

		do {
			System.out.println("\nPlease select one option ");
			System.out.println("(1) Show Sold");
			System.out.println("(2) Deposit");
			System.out.println("(3) Widraw");
			System.out.println("(4) Account");
			System.out.println("(5) Exit");

			int userInput = userInputInt();

			switch (userInput) {
			case 1:
				System.out.println("Your current sold is: " + ATM.currentUser.getBalance() + " \u0024.");
				break;
			case 2:
				System.out.println("Enter the amount you want to deposit into your account:");
				double deposit = userInputDouble();
				ATM.currentUser.setBalance(ATM.currentUser.getBalance() + deposit);
				break;
			case 3:
				System.out.println("Please enter the amount you want to widraw: ");
				double widraw = userInputDouble();
				if ((ATM.currentUser.getBalance() < widraw) || (widraw == 0)) {
					System.err.println("Invalid operation");
				} else {
					System.out
							.println("Are you sure you want to widraw " + widraw + " \u0024 from your account? [Y/N]");
					String userAnswer = userInputString();
					if (userAnswer.equalsIgnoreCase("Y")) {
						System.out.println("Your transaction is complete!");
						ATM.currentUser.setBalance(ATM.currentUser.getBalance() - widraw);
					} else if (userAnswer.equalsIgnoreCase("N")) {
						userOp();
					} else {
						System.err.println("Please enter a valid command!");
					}
				}
				break;
			case 4:
				myAccount();
				break;
			case 5:
				System.err.println("Thank you for using our services!");
				return;
			default:
				System.err.println("Please enter a valid command!");
			}
		} while (true);
	}

	public Users myAccount() {

		System.out.println("\nPlease select one option");
		System.out.println("(1) Change username");
		System.out.println("(2) Change password");
		System.out.println("(3) Return");

		switch (userInputInt()) {
		case 1:
			boolean flagUser = changeUsername();

			if (flagUser == true) {
				System.err.println("The username you specified is already in use. Please choose a different username!");
			} else {
				System.out.println("You have successfully changed your username!");
			}
			break;
		case 2:
			boolean flagPassword = changePassword();

			if (flagPassword == true) {
				System.out.println("You have successfully changed your password!");
			} else {
				changePassword();
			}
			break;
		case 3:
			userOp();
			break;

		default:
			System.err.println("Please enter a valid command!");
		}
		
		return ATM.currentUser;
	}

	public boolean changeUsername() {

		Scanner keyboard = new Scanner(System.in);
		boolean flag = false;

		System.out.println("Please type your new username: ");
		String changeUsername = keyboard.nextLine();

		if (changeUsername.matches("\\w*\\s+\\w*")) {
			System.err.println("Username cannot contain spaces.");
			myAccount();

		} else {
			
			for (int counter = 0; counter < ATM.allUsers.size(); counter++) {
				if (ATM.allUsers.get(counter).getUser().equals(changeUsername)) {
					flag = true;
					return flag;
				} else {
					flag = false;
				}
			}
			
			if (flag == false) {
				ATM.currentUser.setUser(changeUsername);
			}
		}

		return flag;
	}

	public boolean changePassword() {
		
		Scanner keyboard = new Scanner(System.in);
		boolean flag = false;

		System.out.println("Current Password: ");
		String currentPassword = keyboard.nextLine();

		if (ATM.currentUser.getPassword().equals(currentPassword)) {
			System.out.println("New Password: ");
			String newPassword1 = keyboard.nextLine();

			System.out.println("Confirm Password: ");
			String newPassword2 = keyboard.nextLine();

			if (newPassword1.equals(newPassword2)) {
				ATM.currentUser.setPassword(newPassword1);
				flag = true;
				return flag;

			} else {
				System.err.println("These passwords do not match!");
			}

		} else {
			System.err.println("Wrong password!");
			flag = false;
		}

		return flag;
	}
}
