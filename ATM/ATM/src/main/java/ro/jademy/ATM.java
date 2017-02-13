package ro.jademy;

import java.util.ArrayList;

public class ATM {

	// Our Database
	public static ArrayList<Users> allUsers;
	public static Users currentUser;

	
	public static void main(String[] args) {

		allUsers = new ArrayList<Users>();
		Service service = new Service();
		Register register = new Register();
		
		service.initOp();
		service.accountAdmin();

		boolean flag = true;
		
		
		//Show Home Screen
		while (flag == true) {
			service.showHomeScreen();
			int userInput = service.userInputInt();
			switch (userInput) {
			case 1:
				Login login = new Login();

				// in currentUser we store all the credentials

				currentUser = login.loginOp();

				if (currentUser.getEnable() == false) {
					System.err.println("\nYour account is blocked. Please call the bank!\n");
				} else {
					service.userOp();
				}
				flag = false;
				break;
			case 2:
				register.addNewUser();
				break;
			default:
				System.err.println("Please enter a valid command!");

			}
		}

	}

}
