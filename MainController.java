package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MainController implements Initializable {

	// Variables for GUI elements located in the GUI2.fxml file
	@FXML
	private ListView<String> listFull;
	@FXML
	private ListView<String> listBreakfast;
	@FXML
	private ListView<String> listLunch;
	@FXML
	private ListView<String> listDinner;
	@FXML
	private TextField totalPrice;
	@FXML
	private TextField listQueue;
	@FXML
	private TextField txtTimeToComplete;

	@FXML
	private TextField searchBar;
	@FXML
	private ListView<String> listSearchDisplay;

	@FXML
	private ListView<String> listShopCart;

	@FXML
	private javafx.scene.control.TextField coupon;
	String[] coupons = new String[10];
	static String coup = "";

	public static String getCoupon() {
		return coup;
	}

	@FXML
	private Button Admin;
	@FXML
	private TabPane tabPane;

	// for admin tab
	private Tab adminTab = new Tab();
	private SingleSelectionModel<Tab> selectionModel;

	// Global Counter to increment the ID whenever we generate a new Item
	private int idCounter = 0;

	// Global Array for handling searching
	private ArrayList<String> words = new ArrayList<>();

	// Global Menu for handling a shopping cart
	Menu theMenu = new Menu();
	ShoppingCart theCart = new ShoppingCart();

	
	  @FXML private void handleCompleteOrder(ActionEvent event) 
	  {
	  listQueue.setText("0 people ahead");
	  txtTimeToComplete.setText("Estimated wait: 11 minutes"); 
	  }
	 

	@FXML
	private void handleRemoveCart(ActionEvent event) {
		// Checking to make sure the selection is not empty
		if (listShopCart.getSelectionModel().getSelectedItem() != null) {
			// Reset the quantity of the selected item in the cart
			theCart.searchCart(listShopCart.getSelectionModel().getSelectedItem().split(",")[0]).setQuantity(1);

			// Removing the selected item from the list view
			listShopCart.getItems().remove(listShopCart.getSelectionModel().getSelectedIndex());
		}
	}

	@FXML
	private void handleTotalPrice(ActionEvent event) {

		totalPrice.setText(theCart.getTotalAmount() + "");
	}

	@FXML
	private void handleCancelCart(ActionEvent event) {
		// If the shop cart is not empty
		if (listShopCart.getItems().size() != 0) {
			// We loop through the shop cart
			listShopCart.getItems().clear();
			System.out.println("Cancel Cart");
			for (int i = 0; i < theCart.getCartItem().size(); i++) {
				theCart.getCartItem().get(i).setQuantity(1);
			}
		}
	}

	@FXML
	private void handleFullToCart(ActionEvent event) {
		// Get currently selected object in this model
		if (listFull.getSelectionModel().getSelectedItem() != null) {
			String theString = listFull.getSelectionModel().getSelectedItem()
					.substring(listFull.getSelectionModel().getSelectedItem().length() - 1);
			int theInt = Integer.parseInt(theString);
			boolean dupe = false;

			if (listShopCart.getItems().size() == 0) {
				listShopCart.getItems().add(listFull.getSelectionModel().getSelectedItem());
				theCart.addToCart(theMenu.getMenu().get(theInt));
			} else {
				// Check if we have a duplicate
				for (int j = 0; j < listShopCart.getItems().size(); j++) {
					// If the ID of what we have selected is in list view
					if (Integer.parseInt(listShopCart.getItems().get(j)
							.substring(listShopCart.getItems().get(j).length() - 1)) == theInt) {
						// Increment the quantity at this index and then exit the loop
						theCart.searchCart(listFull.getSelectionModel().getSelectedItem().split(",")[0])
								.incrementQuantity(1);

						// Remove the old item
						listShopCart.getItems().remove(j);

						// Replace with new value
						listShopCart.getItems().add(j, theCart
								.searchCart(listFull.getSelectionModel().getSelectedItem().split(",")[0]).getInfo());
						dupe = true;
						break;
					}
					// If the ID of what we have selected is NOT in list view}
				}
				// If the ID of what we have selected is NOT in list view
				if (dupe == false) {
					// We add it to the end and exit loop
					listShopCart.getItems().add(listFull.getSelectionModel().getSelectedItem());
					theCart.addToCart(theMenu.getMenu().get(theInt));
				}
			}

		}
	}

	@FXML
	private void handleBreakFastToCart(ActionEvent event) {
		String theString = listBreakfast.getSelectionModel().getSelectedItem()
				.substring(listBreakfast.getSelectionModel().getSelectedItem().length() - 1);
		int theInt = Integer.parseInt(theString);
		boolean dupe = false;

		if (listShopCart.getItems().size() == 0) {
			listShopCart.getItems().add(listBreakfast.getSelectionModel().getSelectedItem());
			theCart.addToCart(theMenu.getMenu().get(theInt));
		} else {
			// Check if we have a duplicate
			for (int j = 0; j < listShopCart.getItems().size(); j++) {
				// If the ID of what we have selected is in list view
				if (Integer.parseInt(listShopCart.getItems().get(j)
						.substring(listShopCart.getItems().get(j).length() - 1)) == theInt) {
					// Increment the quantity at this index and then exit the loop
					theCart.searchCart(listBreakfast.getSelectionModel().getSelectedItem().split(",")[0])
							.incrementQuantity(1);

					// Remove the old item
					listShopCart.getItems().remove(j);

					// Replace with new value
					listShopCart.getItems().add(j, theCart
							.searchCart(listBreakfast.getSelectionModel().getSelectedItem().split(",")[0]).getInfo());
					dupe = true;
					break;
				}
				// If the ID of what we have selected is NOT in list view}
			}
			// If the ID of what we have selected is NOT in list view
			if (dupe == false) {
				// We add it to the end and exit loop
				listShopCart.getItems().add(listBreakfast.getSelectionModel().getSelectedItem());
				theCart.addToCart(theMenu.getMenu().get(theInt));
			}
		}
	}

	@FXML
	private void handleLunchToCart(ActionEvent event) {
		String theString = listLunch.getSelectionModel().getSelectedItem()
				.substring(listLunch.getSelectionModel().getSelectedItem().length() - 1);
		int theInt = Integer.parseInt(theString);
		boolean dupe = false;

		if (listShopCart.getItems().size() == 0) {
			listShopCart.getItems().add(listLunch.getSelectionModel().getSelectedItem());
			theCart.addToCart(theMenu.getMenu().get(theInt));
		} else {
			// Check if we have a duplicate
			for (int j = 0; j < listShopCart.getItems().size(); j++) {
				// If the ID of what we have selected is in list view
				if (Integer.parseInt(listShopCart.getItems().get(j)
						.substring(listShopCart.getItems().get(j).length() - 1)) == theInt) {
					// Increment the quantity at this index and then exit the loop
					theCart.searchCart(listLunch.getSelectionModel().getSelectedItem().split(",")[0])
							.incrementQuantity(1);

					// Remove the old item
					listShopCart.getItems().remove(j);

					// Replace with new value
					listShopCart.getItems().add(j, theCart
							.searchCart(listLunch.getSelectionModel().getSelectedItem().split(",")[0]).getInfo());
					dupe = true;
					break;
				}
				// If the ID of what we have selected is NOT in list view}
			}
			// If the ID of what we have selected is NOT in list view
			if (dupe == false) {
				// We add it to the end and exit loop
				listShopCart.getItems().add(listLunch.getSelectionModel().getSelectedItem());
				theCart.addToCart(theMenu.getMenu().get(theInt));
			}
		}
	}

	@FXML
	private void handleDinnerToCart(ActionEvent event) {
		String theString = listDinner.getSelectionModel().getSelectedItem()
				.substring(listDinner.getSelectionModel().getSelectedItem().length() - 1);
		int theInt = Integer.parseInt(theString);
		boolean dupe = false;

		if (listShopCart.getItems().size() == 0) {
			listShopCart.getItems().add(listDinner.getSelectionModel().getSelectedItem());
			theCart.addToCart(theMenu.getMenu().get(theInt));
		} else {
			// Check if we have a duplicate
			for (int j = 0; j < listShopCart.getItems().size(); j++) {
				// If the ID of what we have selected is in list view
				if (Integer.parseInt(listShopCart.getItems().get(j)
						.substring(listShopCart.getItems().get(j).length() - 1)) == theInt) {
					// Increment the quantity at this index and then exit the loop
					theCart.searchCart(listDinner.getSelectionModel().getSelectedItem().split(",")[0])
							.incrementQuantity(1);

					// Remove the old item
					listShopCart.getItems().remove(j);

					// Replace with new value
					listShopCart.getItems().add(j, theCart
							.searchCart(listDinner.getSelectionModel().getSelectedItem().split(",")[0]).getInfo());
					dupe = true;
					break;
				}
				// If the ID of what we have selected is NOT in list view}
			}
			// If the ID of what we have selected is NOT in list view
			if (dupe == false) {
				// We add it to the end and exit loop
				listShopCart.getItems().add(listDinner.getSelectionModel().getSelectedItem());
				theCart.addToCart(theMenu.getMenu().get(theInt));
			}
		}
	}

	// Event action to be called
	@FXML
	void search(ActionEvent event) {
		listSearchDisplay.getItems().clear();
		listSearchDisplay.getItems().addAll(searchList(searchBar.getText(), words));
	}

	// Searching, taking into substring of search text
	private List<String> searchList(String searchWords, List<String> listOfStrings) {

		List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

		return listOfStrings.stream().filter(input -> {
			return searchWordsArray.stream().allMatch(word -> input.toLowerCase().contains(word.toLowerCase()));
		}).collect(Collectors.toList());
	}

	// Generating items for the menu
	private Item generateItem(String name, double price, String type, String description, Menu menu_obj) {
		Item newItem = new Item(name, price, type, description, idCounter);
		idCounter = idCounter + 1;
		menu_obj.addItem(newItem);
		return newItem;
	}

	private void populateMenus(Menu menu_obj) {
		System.out.println("Filling list.");

		// Looping through menu list
		for (int i = 0; i < menu_obj.getMenuSize(); i++) {
			// Adding every item to the full menu
			listFull.getItems().add(menu_obj.getMenu().get(i).getInfo());

			// Checking to see which item belongs to which category and adding to it
			switch (menu_obj.getMenu().get(i).getType()) {
			case "Breakfast":
				listBreakfast.getItems().add(menu_obj.getMenu().get(i).getInfo());
				break;
			case "Lunch":
				listLunch.getItems().add(menu_obj.getMenu().get(i).getInfo());
				break;
			case "Dinner":
				listDinner.getItems().add(menu_obj.getMenu().get(i).getInfo());
				break;
			}
		}
	}

	public void checkCoupon(ActionEvent event) {
		boolean flag = true;
		coupons[0] = "coupon0";
		coupons[1] = "coupon1";
		coupons[2] = "coupon2";
		coupons[3] = "coupon3";
		String pons = coupon.getText();
		if (pons.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setContentText("Enter a valid coupon code");
			alert.showAndWait();
		} else {
			for (int i = 0; i < 10; i++) {
				if (pons.equals(coupons[i])) {
					MainController.coup = pons;
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setHeaderText(null);
					alert.setContentText("Valid coupon redeemed for $5.00");
					alert.showAndWait();
					flag = true;
					break;
					// method for adjusting total-$5
				} else {
					flag = false;
				}
				if (i == 9) {
					break;
				}
			}
			if (flag == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setContentText("Invalid coupon code. Try agian.");
				alert.showAndWait();

			}

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Main Controller!");

		// Creating menu object

		// Generating Random items to add to the menu object
		Item chicken = generateItem("chicken", 15.50, "Breakfast", "A good source of protein", theMenu);
		Item bread = generateItem("bread", 15.50, "Dinner", "A good source of protein", theMenu);
		Item chicken2 = generateItem("chicken2", 15.50, "Lunch", "A good source of protein", theMenu);
		Item chicken3 = generateItem("chicken3", 15.50, "Dinner", "A good source of protein", theMenu);

		// Populating GUI Menus with the items
		populateMenus(theMenu);

		// Adding the all menu items for searching.

		for (int i = 0; i < theMenu.getMenuSize(); i++) {
			// Adding every item to the search bar
			listSearchDisplay.getItems().add(theMenu.getMenu().get(i).getName());
			words.add(theMenu.getMenu().get(i).getName());

		}

		// for admin tab
		Admin.setOnMouseClicked(addTab);
		selectionModel = tabPane.getSelectionModel();

	}

	// for admin tab
	EventHandler<MouseEvent> addTab = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			adminTab.setText("Admin");
			adminTab.setClosable(true);
			adminTab.setId("admin");
			try {
				adminTab.setContent(FXMLLoader.load(getClass().getResource("/application/admin.fxml")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tabPane.getTabs().add(adminTab);
			selectionModel.selectLast();
		}
	};
}
