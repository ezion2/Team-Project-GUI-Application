// CSE 360
// Team Project - Admin Class
// Brandon Nosaka, Stephen Lubitz, Zion Esemonu, Jeffrey Lafleur
// This program creates the Admin Class for the team project. The Admin is allowed to distribute coupons to customers 
// and update the menu.

public class Admin extends User{
	
	// default constructor
	Admin() {
		
		// initialize an empty admin
		this.userName = null;
		this.email = null;
		this.password = null;
	}
	
	
	// overloaded constructor
	Admin(String userName, String email, String password){
		
		// initialize an admin
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	
	// distributeCoupon method
	public void distributeCoupon(EndUser customer) {
		
		// create variables needed
		boolean coupon = true;
		
		// give the coupon to the customer
		customer.setCoupon(coupon);
	}
}
