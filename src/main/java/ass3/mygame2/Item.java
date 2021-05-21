
package ass3.mygame2;
/**
 * This is an Item class
 * It stores the name and description of items
 * 
 *
 * @author najam
 * @version 2.1
 */
public class Item
{
    private String description;
    private String name;     //name of item
    private int destructivePower;
    private double healingPower;
    
    /**
     * Item that have a destructive power
     * 
     * @param name item name
     * @param description item description
     * @param destructivePower any power that item have
     */
    public Item(String name, String description, int destructivePower)
    {
        this.name = name;
        this.description = description;
        this.destructivePower = destructivePower;
    }
    
    /**
     * Item that have healing power
     * 
     * @param name name of item
     * @param description description of item
     * @param healingPower healing power of item
     */
    public Item(String name, String description, double healingPower)
    {
        this.name = name;
        this.description = description;
        this.healingPower = healingPower;
    }
    
    /**
     * write accessors and mutators
     * 
     * @return name
     */
    
    public String getName(){
        return name;
    }
    
    /**
     * get the description of items
     * 
     * @return description
     */
    public String getDescription(){
        return description;
    }
    
    /**
     * power of item
     *  @return destructive power of item.
     */
    public int getPower(){
        return destructivePower;
    }
}
