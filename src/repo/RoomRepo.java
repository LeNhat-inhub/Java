package repo;

import constant.Common;
import object.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepo {
    private List<Room> rooms;

    public RoomRepo() {
        rooms = Common.getReadWriteObject().read(Common.roomPath, Room.class);
    }

    public void saveRoom(Room room) {
        Common.getReadWriteObject().write(room, Common.roomPath);
        rooms.add(room);
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
}
