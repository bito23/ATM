package ro.jademy;

public class Login {

	public Users loginOp() {

		Users currentUser = new Users();
		Service service = new Service();

		boolean flag = false;
		int userTry = 0;
		int counter;
		
		// searching for users in our database

		System.out.println("\nPlease type your username: ");
		String username = service.userInputString();

		for (counter = 0; counter < ATM.allUsers.size(); counter++) {
			if (ATM.allUsers.get(counter).getUser().equals(username)) {
				flag = true;
				break;
			}
		}

		while (userTry < 3) {
			if (flag == false) {
				
				System.err.println("User not found!");
				System.out.println(" ");
				System.out.println("Please type your username: ");
				
				username = service.userInputString();

				for (counter = 0; counter < ATM.allUsers.size(); counter++) {
					if (ATM.allUsers.get(counter).getUser().equals(username)) {
						flag = true;
						break;
					}
				}
			}
			if (flag == true) {
				System.out.println("Please type your password: ");
				String password = service.userInputString();
				if (ATM.allUsers.get(counter).getPassword().equals(password)) {
					System.err.println("\nWelcome " + ATM.allUsers.get(counter).getFullname() + "!");
					break;
				} else {
					System.err.println("Wrong password!");
					userTry++;
					continue;
				}
			}
		}
		
		if (userTry == 3) {
			ATM.allUsers.get(counter).setEnable(false);

		}
		
		currentUser = ATM.allUsers.get(counter);
		return currentUser;
	}

}
