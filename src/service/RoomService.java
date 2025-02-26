package service;

import object.Room;
import repo.RoomRepo;
import java.util.Scanner;

public class RoomService {
    private RoomRepo roomRepo;

    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }


    public static Room createRoom() {
        RoomRepo roomRepo = new RoomRepo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Set new room ID: ");
        String id = scanner.nextLine();

        System.out.println("Set new room capacity: ");
        int capacity = scanner.nextInt();

        System.out.println("Set new room price: ");
        long price = scanner.nextLong();

        scanner.nextLine();
        System.out.println("Set new room status: ");
        String status = scanner.nextLine();

        Room room = new Room(id, capacity, price, status);
        roomRepo.saveRoom(room);

        return room;
    }

    public Room updateRoom(String id) {
        Scanner scanner = new Scanner(System.in);

        Room room = roomRepo.findRoomById(id);
        if (room == null) {
            System.out.println("Room with ID " + id + " not found.");
            return null;
        }

        System.out.println("Update room capacity: ");
        int capacity = scanner.nextInt();
        room.setCapacity(capacity);

        System.out.println("Update room price: ");
        long price = scanner.nextLong();
        room.setPrice(price);

        scanner.nextLine();
        System.out.println("Update room status: ");
        String status = scanner.nextLine();
        room.setStatus(status);

        roomRepo.saveRoom(room);
        System.out.println("Room updated successfully!");

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
}
