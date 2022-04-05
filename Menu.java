//from github user joshwible
package application;

import java.util.ArrayList;

public class Menu
{
	
    private ArrayList<Item> menuItems;
    
    public Menu()
    {
        this.menuItems = new ArrayList<Item>(); 
    }
    
    public void addItem(Item item)
    {
    	menuItems.add(item); 
    }
    
    public void removeItem(String name)
    {
        for(Item item : menuItems)
        {
            if(name.equals(item.getName()))
            {
                System.out.println(item.getName() + " has been removed from the menu.");
                menuItems.remove(item);
                break;
            }
        }
        System.out.println("No item found");
    }
    
    public Item getItem(String name)
    {
        for(Item item : menuItems)
        {
            if(name.equals(item.getName()))
            {
                return item;
            }
        }
        return null;
    }
    
    public Item searchMenu(String str)
    {
        for(Item item : menuItems)
        {
            if(item.getInfo().contains(str))
            {
                return item;
            }
        }
        return null;
    }
    public ArrayList<Item> getMenu(){
        return menuItems;
    }
    
    public int getMenuSize(){
        return menuItems.size();
    }
}
