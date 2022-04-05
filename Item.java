package application;

public class Item{
    private String name;        //name of item
    private double price;       //price of item
    private String type;        //appetizer, main course, or dessert
    private String description; //description of item if we choose to display it. 
    private int id;             //Number for each item.
    private int quantity;
    
    public Item(String name, double price, String type, String description, int id){
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.quantity = 1;
        this.id = id;
    }
      
    public String getInfo(){ //used in the menu's search method to find item based on key word
        //return name + ", " + price + ", " + type + ", " + id;
    	//return "Name: " + name + " | Price: " + price + " | Type: " + type + " | Quantity: "+ quantity + " | ID: " + id;
    	return name + "," + price + "," + type + ","+ quantity + "," + id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public String getType(){
        return type;
    }
    public int getId(){
        return id;
    }
     public String getDescription(){
        return description;
    }
     
     public int getQuantity(){
         return quantity;
     }
     
     public void setQuantity(int newQuantity){
         this.quantity =  newQuantity;
     }
     
     public void incrementQuantity(int newQuantity){
         this.quantity = this.quantity + newQuantity;
     }
}
