package ass3.mygame2;


import java.util.ArrayList;

/**
 * Class for <b>Room creation</b>
 * <br>here we cerate new room with description and all
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

        Room castle, kitchen, frontGate, greatHall;

        castle = new Room("castle", "at the castle", false);
        kitchen = new Room("kitchen", "at the kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "at the front Gate, there is a giant ogre", true);
        greatHall = new Room("greatHall", "at the great hall for the feast", true);
        

        castle.setExit("east", kitchen);  //direction and name
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        castle.setExit("west", greatHall);

        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));  //adding item in room
        castle.addItemInRoom(itemCreation.getItem("key"));
        greatHall.addItemInRoom(itemCreation.getItem("painkiller"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));

        allRoomInGame.add(castle);  //adding room
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);
        allRoomInGame.add(greatHall);

    }
    
    /**
     * it will get a specific room
     * 
     * @param stringRoom string of room
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
