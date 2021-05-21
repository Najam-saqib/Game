package ass3.mygame2;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * <b>This is a room class
 * Here we will describe about the room with room names
 * and also what item a room has</b>
 * 
 * @author  Najam
 * @version 2.1
 */

public class Room 
{
    private String description;
    private String name;
    private boolean isLocked;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> roomItem;         //array list of room items
    private HashMap<Room, Item> roomHashMapItem;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     * @param name room name
     * @param isLocked if the room is locked or not
     */
    public Room(String name, String description, boolean isLocked) 
    {
        this.description = description;
        this.name = name;
        this.isLocked = isLocked;
        exits = new HashMap<>();
        roomItem = new ArrayList();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + ".\n" + getAllItems();
    }
    
    /**
     * Return the list of items that you have
     * @return list of items
     */
    public String getAllItems(){

        return "You have some " + listOfItems();   //return list of items

    }
    
    /**
     * it will add items in a string
     * @return string of items
     */
    private String listOfItems(){

        String returnString = "items:";
        for(Item item : roomItem){    //for loop
            returnString += " " + item.getName();           
        }
        return returnString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;   //return command
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Method getRoomItem
     *
     * @param stringItem taken from the command which was converted into a String
     * @return Item class according to the input String
     */
    public Item getRoomItem(String stringItem){
        Item itemToReturn = null;
        for(Item item: roomItem){
            if(item.getName().contains(stringItem)){
                itemToReturn = item;
            }
        }
        return itemToReturn;
    }
    
    /**
     * it will add items in room
     * @param item items like sword
     */
    public void addItemInRoom(Item item){
        roomItem.add(item);
    }
    
    
    /**
     * It will remove items from room
     * @param item 
     */
    public void removeItemInRoom(Item item){
        if(roomItem.size() > 0){
            roomItem.remove(item);
        }
    }
    
    /**
     * 
     * @param room
     * @param item 
     */
    public void addHashMapItemInRoom(Room room, Item item){
        roomHashMapItem.put(room, item);
    }

    /**
     * Method getLockedStatus
     *
     * @return The return value
     */

    public boolean getLockedStatus(){
        return isLocked;
    }
    
    /**
     * get new status of room after unlock
     * @param newStatus new status of room
     */
    public void setLockedStatus(boolean newStatus){
        isLocked = newStatus;
    }
    
    /**
     * it will get name
     * @return name
     */
    public String getName(){
        return name;
    }

    
}

