package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {
	
	// Variables for GUI elements located in the GUI2.fxml file
	@FXML private ListView listFull;
	@FXML private ListView listBreakfast;
	@FXML private ListView listLunch;
	@FXML private ListView listDinner;
	
    @FXML private TextField searchBar;
    @FXML private ListView<String> listSearchDisplay;
	
	@FXML private ListView listShopCart;
	
	// Global Counter to increment the ID whenever we generate a new Item
	private int idCounter = 0;
	
	// Global Array for handling searching
    private ArrayList<String> words = new ArrayList<>();
    

	@FXML private void addToCart(MouseEvent event)
	{
		System.out.println("Adding to cart");
	}
	
	
	
	
	
	
	
	
	
	// Event action to be called
    @FXML void search(ActionEvent event) 
    {
        listSearchDisplay.getItems().clear();
        listSearchDisplay.getItems().addAll(searchList(searchBar.getText(),words));
    }
    
    // Searching, taking into substring of search text
    private List<String> searchList(String searchWords, List<String> listOfStrings) 
    {

        List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));

        return listOfStrings.stream().filter(input -> 
        {
            return searchWordsArray.stream().allMatch(word ->
                    input.toLowerCase().contains(word.toLowerCase()));
        }).collect(Collectors.toList());
    }
	
	// Generating items for the menu
	private Item generateItem(String name, double price, String type,  String description, Menu menu_obj)
	{
		Item newItem = new Item(name, price, type, description, idCounter);
		idCounter = idCounter + 1;
		menu_obj.addItem(newItem);
		return newItem;
	}
	
	private void populateMenus(Menu menu_obj)
	{
		System.out.println("Filling list.");
		
		// Looping through menu list
		for(int i = 0; i < menu_obj.getMenuSize(); i++)
		{
			// Adding every item to the full menu
			listFull.getItems().add(menu_obj.getMenu().get(i).getInfo());
			
			// Checking to see which item belongs to which category and adding to it
			switch (menu_obj.getMenu().get(i).getType())
			{
				case "Breakfast": listBreakfast.getItems().add(menu_obj.getMenu().get(i).getInfo());
					break;
				case "Lunch": listLunch.getItems().add(menu_obj.getMenu().get(i).getInfo());
					break;
				case "Dinner": listDinner.getItems().add(menu_obj.getMenu().get(i).getInfo());
					break;
			}
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Main Controller!");
		
		// Creating menu object
		Menu theMenu = new Menu();
		
		// Generating Random items to add to the menu object
		Item chicken = generateItem("chicken", 15.50, "Breakfast", "A good source of protein", theMenu);
		Item bread = generateItem("bread", 15.50, "Dinner", "A good source of protein", theMenu);
		Item chicken2 = generateItem("chicken2", 15.50, "Lunch", "A good source of protein", theMenu);
		Item chicken3 = generateItem("chicken3", 15.50, "Dinner", "A good source of protein", theMenu);

		// Populating GUI Menus with the items
		populateMenus(theMenu);
		
		// Adding the all menu items for searching.
		
		
		for(int i = 0; i < theMenu.getMenuSize(); i++)
		{
			// Adding every item to the search bar
			listSearchDisplay.getItems().add(theMenu.getMenu().get(i).getName());
			words.add(theMenu.getMenu().get(i).getName());
			
		}
		
	}

}
