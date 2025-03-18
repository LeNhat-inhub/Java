package controller;

import constant.Common;
import object.Room;
import object.RoomManagement;
import object.RoomManagementDetail;
import object.Staff;
import service.CustomerService;
import service.RoomManagementService;
import service.RoomService;
import service.StaffService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RoomManagementController {
    public RoomManagementService roomManagementService;
    private RoomService roomService;
    private CustomerController customerController;
    private CustomerService customerService;
    private StaffService staffService;
    private RoomManagement roomManagement;
    private Room room;

    public RoomManagementController() {
        this.roomManagementService = new RoomManagementService();
        this.roomService = new RoomService();
        this.room = new Room();
    }

    public void  chooseRoom(Scanner sc) {
        List<Room> remainingRooms = roomService.getAllRooms();
        remainingRooms.forEach(System.out::println);
        System.out.println("Enter the number of rooms you want to reserve: ");
        int number = sc.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the room you want to reserve: ");
            String roomNum = sc.nextLine();
            Room room = roomService.findRoomById(roomNum);

            RoomManagementDetail roomManagementDetail = new RoomManagementDetail(room,room.getPrice());
        }
    }
    public void createInvoice(Scanner sc) {
        RoomManagement tempRoomManagement = new RoomManagement();
        System.out.println("Enter the start date(dd/MM/yyyy): ");
        tempRoomManagement.setStartTime(LocalDate.parse(sc.nextLine(), Common.dtf));
        System.out.println("Enter the end date(dd/MM/yyyy): ");
        tempRoomManagement.setEndTime(LocalDate.parse(sc.nextLine(), Common.dtf));

        System.out.println("Sign up(0)/ sign in(1) your id: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    customerController.createCustomer(sc);
                    break;
                case 1:
                    System.out.println("Enter the number ID: ");
                    String customerId = sc.nextLine();
                    customerService.findCustomerById(customerId);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        System.out.println("Enter the Staff Identity Number: ");
        String staffId = sc.nextLine();
        Staff staff = staffService.findStaffById(staffId);
        tempRoomManagement.setStaff(staff);
        tempRoomManagement.setDate(LocalDate.now());


        RoomManagement roomManagement = roomManagementService.createInvoice(tempRoomManagement);
        System.out.println("Successfully created");
    }

}