package springmvc.model;

public class User {

	private String userEmail;
	private String userName;
	private String userPassword;

	public String getuserEmail() {
		return userEmail;
	}

	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getuserPassword() {
		return userPassword;
	}

	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}

}
