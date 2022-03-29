// CSE 360
// Team Project - User Class
// Brandon Nosaka, Stephen Lubitz, Zion Esemonu, Jeffrey Lafleur
// This program creates the EndUser Class for the team project. The EndUser is the customer and allows the customer to update their cart and address.

public class EndUser {
  
  protected String foodCart;
  protected String address;
  
  //constructor
  EndUser(){
    this.foodCart = null;
    this.address = null;
  }
  
  //overload constructor
  EndUser(String foodCart, String address){
    this.foodCart = foodCart;
    this.address = address;
  }
  
  //getFoodCart method
  public String getFoodCart(){
    return this.foodCart;
  }
  
  //getAddress method
  public String getAddress(){
    return this.address;
  }
}
