import java.util.Scanner;

public class Login {
	public void initLogin() {
		//Scanner scan = new Scanner(); maybe have a .txt where usernames and passwords are saved then checked against user input
		Scanner keyboard = new Scanner(System.in);
		String userName = scan.nextLine();
		String password = scan.nextLine();
		
		String inputUserName = keyboard.nextLine();
		String inputPassword = keyboard.nextLine();
		
		if(inputUserName.equals(user) && inputPassword.contentEquals(password)) {
			System.out.println("Logging in");
		}
		else {
			System.out.println("Username or Password incorrect. Please try again.");
		}
				
	}
}
