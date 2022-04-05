package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginController implements Initializable{
	static ObservableList list = FXCollections.observableArrayList();
	String username = "user";
	String password = "123";
	String[] users = new String[100];
	String[] passwords = new String[100];
	//users[0] = "user";
	//password[0] = "123";
	static String uname = "";
	static String newName = "";
	static String newPas = "";
	int index=3;
	public String regUsername;
	public String regPassword;
	
		@FXML
		private javafx.scene.control.TextField user;
		@FXML
		private javafx.scene.control.TextField pass;
		@FXML
		private javafx.scene.control.TextField newUser;
		@FXML
		private javafx.scene.control.TextField newPass;
		@FXML
		private javafx.scene.control.TextField rePass;
	
	private Tab adminTab = new Tab();
	@Override	
	public void initialize (URL arg0, ResourceBundle arg1) {
		String user = LoginController.getVariable();
		System.out.println("Hello " + user);
	}
	public static String getVariable() {
		return uname;
	}
		@FXML
	
		public void loginUser(ActionEvent event) throws IOException {
			boolean flag=true;
			boolean admin=false;
			users[0] = "user";
			passwords[0] = "123";
			users[1] = "user2";
			passwords[1] = "1234";
			users[2] = "admin";
			passwords[2] = "secure";
			String name = user.getText();
			String passw = pass.getText();
			if(name.isEmpty()||passw.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Fill all required fields");
				alert.showAndWait();
			}else{
				for(int i=0;i<100;i++) {
					if(name.equals(users[i]) && passw.equals(passwords[i])) {
						if(name.equals("admin")) {
							admin=true;
							LoginController.uname=name;
							EventHandler<MouseEvent> addTab = new EventHandler<MouseEvent>() {

								@Override
								public void handle(MouseEvent event) {
									adminTab.setText("Admin");
									adminTab.setClosable(true);
									adminTab.setId("admin");
									
								}
								
							}
							
							//((Node)event.getSource()).getScene().getWindow().hide();
							//loadWindow("/application/Gui2.fxml");
							flag=true;
							break;
						}else {
							admin=false;
							LoginController.uname=name;
							((Node)event.getSource()).getScene().getWindow().hide();
							loadWindow("/application/Gui2.fxml");
							flag=true;
							break;
							}
					}else{
						flag=false;
						}
		
				if(i==99) {
					break;
				}
				}
				if(flag==false) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setContentText("Invalid username or password. Try agian.");
					alert.showAndWait();
					
				}
				
			
			}
		}
		
		private void loadWindow(String location) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("Gui2.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
		}

		public void newLoginUser(ActionEvent event) throws IOException {
			String name = newUser.getText();
			String passw = newPass.getText();
			String rePassw = rePass.getText();
			if(name.isEmpty()||passw.isEmpty()||rePassw.isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Fill all required fields");
				alert.showAndWait();
			}else if(passw.equals(rePassw)) {
					LoginController.uname=name;
					LoginController.newPas=passw;
					users[index] = name;
					passwords[index] = passw;
					index++;
					((Node)event.getSource()).getScene().getWindow().hide();
					loadWindow("/application/Gui2.fxml");
					System.out.println(users[3] + " "+ passwords[3]);
				}
			 else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Passwords do not match. Try agian.");
				alert.showAndWait();
				}
			}
}
