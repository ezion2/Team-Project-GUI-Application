package application;

import java.util.ArrayList;
import java.util.ListIterator;

class ShoppingCart
{
  private ArrayList<Item> cartItem;
  private double totalAmount;
  private boolean coupon;
  
  public ShoppingCart()
  {
    this.cartItem = new ArrayList<Item>();
    this.coupon = false;
    this.totalAmount = 0;
  }
  
  public void addToCart(Item item)
  {
    this.cartItem.add(item);
  }
  
  	public void showCart() 
  	{
		ListIterator<Item> iterator = cartItem.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.println(item1);
		}
	}
  
    public void removeFromCart(String name)
    {
        for(Item item : cartItem)
        {
            if(name.equals(item.getName()))
            {
                System.out.println(item.getName() + " has been removed from the menu.");
                cartItem.remove(item);
                break;
            }
        }
        System.out.println("No item found");
    }
    
    /*public Item searchCart(int id)
    {
        for(Item item : cartItem)
        {
            if(item.getId() == id)
            {
                return item;
            }
        }
        return null;
    }*/
    
    public Item searchCart(String str)
    {
        for(Item item : cartItem)
        {
            if(item.getInfo().contains(str))
            {
                return item;
            }
        }
        return null;
    }
  	
  	public double getTotalAmount() 
  	{
		this.totalAmount = 0;
        for(Item item : cartItem)
        {
        	this.totalAmount = this.totalAmount + item.getPrice();
        }
		return this.totalAmount;
	}
  	
  	public void applyCoupon() 
  	{ //this method allows for a coupon to be applied, Ive added it to the class if we need it for later. 
		this.coupon = true;
	}
}
  
  
