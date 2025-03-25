package controller;

import constant.Common;
import object.*;
import service.CustomerService;
import service.RoomManagementService;
import service.RoomService;
import service.StaffService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class RoomManagementController {
    public RoomManagementService roomManagementService;
    private RoomService roomService;
    private CustomerController customerController;
    private CustomerService customerService;
    private StaffService staffService;

    public RoomManagementController() {
        this.roomManagementService = new RoomManagementService();
        this.roomService = new RoomService();
        this.customerController = new CustomerController();
        this.customerService = new CustomerService();
        this.staffService = new StaffService();
    }
    RoomManagement tempRoomManagement = new RoomManagement();


    public void chooseRoom(Scanner sc) {
        boolean flag = true;
        List<Room> allRooms = roomService.getAllRooms();
        List<RoomManagementDetail> bookedRooms = roomManagementService.getAllRoomManagementDetails();

        System.out.println("All Rooms:");
        allRooms.forEach(System.out::println);
        Common.clearBuffer(sc);

        System.out.println("Enter the start date(dd/MM/yyyy): ");
        LocalDate startDate = null;
        while (startDate == null) {
            try {
                startDate = LocalDate.parse(sc.nextLine(), Common.dtf);
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format! Please enter again (dd/MM/yyyy): ");
            }
        }
        tempRoomManagement.setStartTime(startDate);
        System.out.println("Enter the end date(dd/MM/yyyy): ");
        LocalDate endDate = null;
        while (endDate == null || endDate.isBefore(startDate)) {
            try {
                endDate = LocalDate.parse(sc.nextLine(), Common.dtf);
                if (endDate.isBefore(startDate)) {
                    System.out.print("End date must be after start date! Enter again: ");
                }
            } catch (DateTimeParseException e) {
                System.out.print("Invalid date format! Please enter again (dd/MM/yyyy): ");
            }
        }
        tempRoomManagement.setEndTime(endDate);
        List<Room> availableRooms = roomManagementService.getAvailableRooms(
                roomService.getAllRooms(),
                roomManagementService.getAllRoomManagementDetails(),
                startDate,
                endDate
        );
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for the selected dates.");
            return;
        }else{
            System.out.println("Already:");
        }
        System.out.println("Available Rooms: ");
        availableRooms.forEach(System.out::println);

        System.out.println("Enter the number of rooms you want to reserve: ");
        int number = sc.nextInt();
        if (number <= availableRooms.size() && number > 0) {
            for (int i = 0; i < number; i++) {
                Common.clearBuffer(sc);
                System.out.println("Enter the room you want to reserve: ");
                String id = sc.nextLine();
                Room room = roomService.findRoomById(id);
                RoomManagementDetail roomManagementDetail = new RoomManagementDetail(room, room.getPrice(), startDate, endDate);
                tempRoomManagement.addRoomManagementDetail(roomManagementDetail);
                System.out.println("Rooms in Management: " + tempRoomManagement.getRoomManagementDetailList());

            }
        } else {
            System.out.println("Not enough rooms available");
            flag = false;
        }
    }

    public void createInvoice(Scanner sc) {
        boolean flag = true;

        System.out.println("Sign up(0)/ sign in(1) your id: ");
        int choice = -1;
        while (choice != 0 && choice != 1) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice != 0 && choice != 1) {
                    System.out.print("Invalid choice! Enter 0 (Sign up) or 1 (Sign in): ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter 0 (Sign up) or 1 (Sign in): ");
            }
        }
        if (choice == 0) {
            Customer customer = customerController.createCustomer(sc);
            System.out.println(customer);
            tempRoomManagement.setCustomer(customer);
        } else {
            System.out.print("Enter customer ID: ");
            String customerId = sc.nextLine().trim();
            while (customerId.isEmpty()) {
                System.out.print("Customer ID cannot be empty! Enter again: ");
                customerId = sc.nextLine().trim();
            }

            Customer customer = customerService.findCustomerById(customerId);
            tempRoomManagement.setCustomer(customer);
            if (customer == null) {
                System.out.println("Customer not found!");
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Enter the Staff Identity Number: ");
            Staff staff;
            String staffId = sc.nextLine();
            while (staffId.isEmpty()) {
                System.out.print("Staff ID cannot be empty! Enter again: ");
                staffId = sc.nextLine();
            }
            staff = staffService.findStaffById(staffId);
            System.out.println(staff);
            if (staff == null) {
                System.out.println("Staff not found");
                flag = false;
            } else {
                tempRoomManagement.setStaff(staff);
            }

            tempRoomManagement.setDate(LocalDate.now());

            RoomManagement roomManagement = roomManagementService.createInvoice(tempRoomManagement);
            System.out.println("Successfully created");
            System.out.println(roomManagement);
        }
    }

    public void getAllManagement() {
        List<RoomManagement> roomManagementList = roomManagementService.getAllManagement();
        if (!roomManagementList.isEmpty()) {
            System.out.println("LIST OF :");
            roomManagementList.forEach(System.out::println);
        } else
            System.out.println("No found");
    }
}