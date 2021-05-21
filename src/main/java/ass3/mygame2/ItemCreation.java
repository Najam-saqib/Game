package ass3.mygame2;

import java.util.ArrayList;


/**
 * Write a description of class ItemCreation here.
 *
 * @author najam
 * @version 2.1
 */
public class ItemCreation
{
    
    private ArrayList<Item> allItemsInGame;
    
    /**
     * this will create a new array list for items
     */
    public ItemCreation()
    {       
        allItemsInGame = new ArrayList();
        createItems();
    }
    
    /**
     * it will create items
     * items like key, sword etc
     */
    public void createItems(){
        
        Item item1, item2, excaliburSword, key, frontGateKey;
        
        
        excaliburSword = new Item("excaliburSword", "The legendary Excalibur", 100);
        key = new Item("key", "It has a shape of a heart", 100);
        frontGateKey = new Item("frontGateKey", "To open the front gate door", 100);
        
        allItemsInGame.add(excaliburSword);  //add item description
        allItemsInGame.add(key);
        allItemsInGame.add(frontGateKey);
    }
   
    /**
     * it will get items
     * @param stringItem 
     * @return items
     */
    public Item getItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: allItemsInGame){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
  
    
}
