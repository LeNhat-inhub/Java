package controller;

import object.Room;
import service.RoomService;

import java.util.List;
import java.util.Scanner;

public class RoomController {
    public RoomService roomService;

    public RoomController() {
        this.roomService = new RoomService();
    }

    public void createRoom(Scanner sc) {
        Room tempRoom = new Room();
        sc.nextLine();
        System.out.println("Enter Room ID:");
        tempRoom.setId(sc.nextLine());
        System.out.println("Enter Room Capacity:");
        tempRoom.setCapacity(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter Room Price:");
        tempRoom.setPrice(sc.nextLong());
        sc.nextLine();
        Room room = roomService.createRoom(tempRoom);
        System.out.println("Room ID: " + room.getId() + " is created");
    }
    public void updateRoom(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter Room ID:");
        String id = sc.nextLine();
        Room tempRoom = roomService.findRoomById(id);
        if (tempRoom != null) {
            System.out.println("Enter new Room Capacity:");
            tempRoom.setCapacity(sc.nextInt());
            System.out.println("Enter new Room Price:");
            tempRoom.setPrice(sc.nextLong());
        }
        Room room = roomService.updateRoom(id);
        System.out.println("Room ID: " + room.getId() + " is modified");
    }
    public boolean deleteRoom(Scanner sc) {
        System.out.println("Enter Room ID:");
        String id = sc.nextLine();
        Room room = roomService.findRoomById(id);
        if (room != null){
            return roomService.deleteRoom(id);
        }
        return false;
    }

    public void getAllRooms() {
        List<Room> roomList = roomService.getAllRooms();
        if (!roomList.isEmpty()) {
            System.out.println("LIST OF ROOMS:");
            roomList.forEach(System.out::println);
        } else
            System.out.println("No rooms found");
    }
}
