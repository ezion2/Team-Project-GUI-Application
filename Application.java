// CSE 360
// Team Project - Admin Class
// Brandon Nosaka, Stephen Lubitz, Zion Esemonu, Jeffrey Lafleur
// This program creates the Admin Class for the team project. The Admin is allowed to distribute coupons to customers 
// and update the menu.

import java.io.*;
import java.util.*;

public class Application
{
		
	protected User[] user;
	public User[] getUser() 
	{
		return this.user;
	}	
	
	public boolean verifyLogin(User user, String userName, String password) {
		return userName.equals(user.userName) && password.equals(user.password);
		/*if (userName.equals(user.userName)) {
			if(password.equals(user.password)) {
				return true;
			}
			
			else {
				return false;
			}
		}
		else {
			return false;
		}*/
	}
}
		
			
	//public addToQueue() {
			
		//}
	//public menu() {
	//}	
//}
