package controller;

import object.*;
import service.CustomerService;
import service.RoomManagementService;
import service.RoomService;
import service.StaffService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RoomManagementController {
    public RoomManagementService roomManagementService;
    private RoomService roomService;
    private CustomerController customerController;
    private CustomerService customerService;
    private StaffService staffService;

    public RoomManagementController() {
        this.roomManagementService = new RoomManagementService();
    }

    ArrayList<Room> rooms;
    public void createInvoice(Scanner sc) {
        List<Room> roomList = roomService.getAllRooms();
        roomList.forEach(System.out::println);
        System.out.println("Enter the number of rooms you want to buy: ");
        String roomNum = sc.nextLine();
        Room roomByNum = roomService.findRoomById(roomNum);
        RoomManagement tempRoomManagement = new RoomManagement();

        if(roomByNum != null){
            tempRoomManagement.setRoomManagementDetailList(roomByNum);
            System.out.println("Sign up(0)/ sign in(1) your id: ");
            int choice = sc.nextInt();
            switch(choice) {
                    case 0:
                        customerController.createCustomer(sc);
                        break;
                    case 1:
                        System.out.println("Enter the number ID: ");
                        UUID customerId = UUID.fromString(sc.nextLine());
                        customerService.findCustomerById(customerId);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }

            System.out.println("Enter the Staff ID: ");
            UUID staffId = UUID.fromString(sc.nextLine());
            Staff staff = staffService.findStaffById(staffId);
            tempRoomManagement.setStaff(staff);

            RoomManagement roomManagement = roomManagementService.saveInvoice(tempRoomManagement);
        }
    }
}
