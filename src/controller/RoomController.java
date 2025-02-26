package controller;

import object.Room;
import service.RoomService;

import java.util.Scanner;

public class RoomController {
    public RoomService roomService = new RoomService();

    public Room createRoom(String id, int capacity, Long price, String status) {
            Scanner sc = new Scanner(System.in);

            return roomService(id, capacity, price, status);
        }

    private Room roomService(String id, int capacity, Long price, String status) {
    }

}
