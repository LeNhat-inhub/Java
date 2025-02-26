package repo;

import object.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepo {
    private List<Room> rooms;

    public RoomRepo() {
        rooms = new ArrayList<>();
    }

    public void saveRoom(Room room) {
        rooms.add(room);
        System.out.println("Room saved successfully!");
    }

    public Room findRoomById(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public boolean deleteRoomById(String id) {
        Room room = findRoomById(id);
        if (room != null) {
            rooms.remove(room);
            return true;
        }
        return false;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
String url = "./src/data/room.bin";
}
