package service;

import object.Room;
import repo.RoomRepo;

import java.util.List;


public class RoomService {
    private RoomRepo roomRepo;

    public RoomService() {
        this.roomRepo = new RoomRepo();
    }

    public Room createRoom(Room room) {
        roomRepo.saveRoom(room);
        return room;
    }

    public Room updateRoom(String id) {
        Room room = roomRepo.findRoomById(id);
        roomRepo.saveRoom(room);
        return room;
    }

    public boolean deleteRoom(String id) {
        boolean isDeleted = roomRepo.deleteRoomById(id);

        if (isDeleted) {
            System.out.println("Room deleted successfully!");
        } else {
            System.out.println("Room with ID " + id + " not found.");
        }

        return isDeleted;
    }
    public Room findRoomById(String id) {
        return roomRepo.findRoomById(id);
    }
    public List<Room> getAllRooms() {
        return roomRepo.getAllRooms();
    }
}
