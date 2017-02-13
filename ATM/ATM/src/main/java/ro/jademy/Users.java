package ro.jademy;

public class Users {
	private String user;
	private String password;
	private String fullname;
	private double balance;
	private boolean enable = true;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString() {
		return "Username: " + user + "\nPassword: " + password + "\nFull name: " + fullname + "\nBalance: " + balance
				+ "\nStatus: " + enable;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
