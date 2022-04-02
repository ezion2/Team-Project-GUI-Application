public class Item{
    private String name;        //name of item
    private double price;       //price of item
    private String type;        //appetizer, main course, or dessert
    
    public Item(String name, double price, String type,  String description, int cookTime){
        this.name = name;
        this.price = price;
        this.type = type;
    }
    
    public Item(Item item){
        this.name = name;
        this.price = price;
        this.type = type;
    }
      
    public String getInfo(){ //used in the menu's search method to find item based on key word
        return name + " " + price + " " + type;
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
}
