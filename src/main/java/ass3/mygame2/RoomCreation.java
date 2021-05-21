package ass3.mygame2;


import java.util.ArrayList;

/**
 * class for room creation
 * here we cerate new room with description and all
 * 
 * @author najam
 * @version 2.1
 */

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;
    
    /**
     * room creation
     */
    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    /**
     * rooms with description and name
     */
    private void createRooms() {

        Room castle, kitchen, frontGate;

        castle = new Room("castle", "You are at the castle", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        

        castle.setExit("east", kitchen);  //direction and name
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));  //adding item in room
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));

        allRoomInGame.add(castle);  //adding room
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);

    }
    
    /**
     * it will get a specific room
     * 
     * @param stringRoom
     * @return room 
     */
    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn; //return command
    }

}
