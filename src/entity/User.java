package entity;

public class User {

	
	private int userId;
	private String userUsername;
	private String userFirstName;
	private String userLastName;
	private String userBirthDate;
	private String userEmail;
	private String userPassword;
	
	public User(int userId, String userUsername, String userFirstName, String userLastName, String userBirthDate, 
			String userEmail, String password) {
		this.setUserId(userId);
		this.setUserUsername(userUsername);
		this.setUserFirstName(userFirstName);
		this.setUserLastName(userLastName);
		this.setUserBirthDate(userBirthDate);
		this.setUserEmail(userEmail);
		this.setUserPassword(password);
	
	
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserBirthDate() {
		return userBirthDate;
	}

	public void setUserBirthDate(String userBirthDate) {
		this.userBirthDate = userBirthDate;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
}
