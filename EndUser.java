// CSE 360
// Team Project - User Class
// Brandon Nosaka, Stephen Lubitz, Zion Esemonu, Jeffrey Lafleur
// This program creates the User Class for the team project. The User has their own profile and can login, logout, and register.

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
