package ro.jademy;

public class Register {

	String newUsername;
	String newPassword;
	String newFullName;
	double newBalance;

	Users newUser;

	// Register operation
	public void addNewUser() {

		Service service = new Service();

		newUser = new Users();
		boolean flag = true;

		System.out.println("Please choose an username: ");
		newUsername = service.userInputNextLineSingle();

		if (newUsername.matches("\\w*\\s+\\w*")) {
			System.err.println("Username cannot contain spaces.");
			return;

		} else {

			for (int counter = 0; counter < ATM.allUsers.size(); counter++) {
				if (ATM.allUsers.get(counter).getUser().equals(newUsername)) {
					flag = false;
				} else {
					flag = true;
				}
			}

			if (flag == false) {
				System.err.println("The username you specified is already in use. Please choose a different username!");
				return;
			} else {

				newUser.setUser(newUsername);
				System.out.println("Please choose a password: ");
				newPassword = service.userInputString();
				newUser.setPassword(newPassword);

				System.out.println("Please type your full name: ");
				newFullName = service.userInputNextLine();
				newUser.setFullname(newFullName);

				System.out.println("Please insert how much you want to deposit into your account: ");
				newBalance = service.userInputDouble();
				newUser.setBalance(newBalance);

			}
		}

		ATM.allUsers.add(newUser);
	}
}
