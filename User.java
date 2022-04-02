// CSE 360
// Team Project - User Class
// Brandon Nosaka, Stephen Lubitz, Zion Esemonu, Jeffrey Lafleur
// This program creates the User Class for the team project. The User has their own profile and can login, logout, and register.

public abstract class User {
	
	
	// declare properties needed
	protected String userName;
	protected String email;
	protected String password;
	
	
	// default constructor delete this
	User(){
		
		// initialize an empty user
		this.userName = null;
		this.email = null;
		this.password = null;
	}
	
	
	// overloaded constructor
	User(String userName, String email, String password){
		
		// initialize a user
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	
	// getUserName method
	public String getUserName(){
		
		// return the user's userName
		return this.userName;
	}
	
	
	// getEmail method
	public String getEmail() {
		
		// return the user's email
		return this.email;
	}
	
	
	// getPassword method
	public String getPassword() {
		
		// return the user's password
		return this.password;
	}
}
