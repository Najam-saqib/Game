/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass3.mygame2;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * <b>Game class</b>
 * <br>It will have players, room and items in it
 * 
 *<br>It also contain welcome note in it
 *@author Najam
 * @version 2.1
 */

public class Game {

    private Parser parser;
    private Player player;
    private Room currentRoom;
    private RoomCreation rooms;

    private HashMap<Item, Room> roomItem;

    private HashMap<Item, Room> roomKey;

    private int timeCounter; // to count the steps

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        long timeStart = System.currentTimeMillis(); // use the real time
        timeCounter = 50;
        parser = new Parser();
        player = new Player();
        rooms = new RoomCreation();
        currentRoom = rooms.getRoom("castle");  // start game outside
        
    }
    
    /**
     * name of current room in which user starts
     * @return currentRoom
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    
    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
        boolean finished = false;
        while (!finished) {
            long currentTime = System.currentTimeMillis();
            Command command = parser.getCommand();          
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to World of Zuul ");
        System.out.println("Your objective is to escape");
        System.out.println("You have a time limit of 15 mins ");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    public boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("inventory")) {
            printInventory(); // printVeggies
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("take")) {
            takeItem(command);
        } else if (commandWord.equals("drop")) {
            dropItem(command);
        } else if (commandWord.equals("use")) {
            //useItem(command);
        } else if (commandWord.equals("inspect")) {
            //lookItem(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    
    /**
     * Print out some help information. Here we print some cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println("");

        // implement random Hints -> massive bonus points 
        System.out.println("you can open the door using the use command");

        System.out.println("you need to clear the ogre before you can open the kitchen door");

        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    /**
    * This will print Inventory
    */
    private void printInventory() {
        System.out.println(player.printAllInventory());
    }

    /**
     * Try to in to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     * 
     */
    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            if (currentRoom.getLockedStatus() == true) { // the door is locked
                System.out.println("The door is locked, you need to find a way to open it");// need to find key
                System.out.println(currentRoom.getLongDescription());
            } else {
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
                
                // increment the timeCounter
            }
        }
    }
    /**If there is a item to take then take it
     * otherwise print an error message.
     * 
     * @param command 
     */
    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            currentRoom.removeItemInRoom(currentItem);
            player.addItemInventory(currentItem);

            
        }
    }
    /**
     * there is some item to drop, then drop it
     * otherwise print an error message.
     * @param command 
     */
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = player.getPlayerItem(itemFromCommand);
        //getPlayerItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't take nothing, no?");
        } else {
            // Do the transaction here
            player.removeItemInventory(currentItem);
            currentRoom.addItemInRoom(currentItem);

            
        }
    }
    /**
     * If there is some item to use then use it
     * otherwise print an error message.
     * @param command 
     */
    private void useItem(Command command) // use key
    {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }

        String itemFromCommand = command.getSecondWord();
        Item currentItem = currentRoom.getRoomItem(itemFromCommand);

        if (currentItem == null) {
            System.out.println("You can't use nothing, no?");
        } else {
            // you want make sure that the currentRoom is the room where you want to open the door (before the nextdoor).
            // you want to make sure the currentItem matches the key to open the next door.

            
            System.out.println("You just used the " + currentItem.getName());
            System.out.println("You cannot use this item here");

        }

    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

}

