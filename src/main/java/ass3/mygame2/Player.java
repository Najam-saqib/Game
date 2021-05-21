package ass3.mygame2;


import java.util.ArrayList;


/**
 * array list of player
 *
 * @author Najam
 * @version 2.1
 */
public class Player
{
    
    private ArrayList<Item> playerItem;
    
    public Player()
    {
        playerItem = new ArrayList();
    }
    
    /**
     * add item in inventory
     * @param item 
     */
    
    public void addItemInventory(Item item){
        playerItem.add(item);
        System.out.println(item.getDescription() + " was taken ");  //when you take an item
        
    }
    
    /**
     * remove item from inventory
     * @param item 
     */
    public void removeItemInventory(Item item){
        playerItem.remove(item);
        System.out.println(item.getName() + " was removed from your inventory"); //when you remove an item
    }
    
    /**
     * get player items
     * @param stringItem
     * @return item
     */
    public Item getPlayerItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: playerItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    /**
     * print inventory of player
     * @return string
     */
    public String printAllInventory(){

        String returnString = "Items:";
        for(Item item : playerItem){
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    
}
