package other;

import constant.Common;
import controller.CustomerController;
import controller.RoomController;
import controller.RoomManagementController;
import controller.StaffController;
import object.Room;

import java.util.ArrayList;
import java.util.Scanner;

import static constant.Common.scanner;

public class Menu {
    public RoomController roomController;
    public CustomerController customerController;
    public RoomManagementController roomManagementController;
    public StaffController staffController;

    public Menu() {
        roomController = new RoomController();
        customerController = new CustomerController();
        roomManagementController = new RoomManagementController();
        staffController = new StaffController();
    }

    public int printMenu(Scanner sc) {
        System.out.println("Select an option:");
        System.out.println("1. Add Room");
        System.out.println("2. Update Room by ID");
//        System.out.println("3. Create Customer");
//        System.out.println("4. Create Staff");
//        System.out.println("5. Create Invoice");
//        System.out.println("6. Find Invoice by ID");
//        System.out.println("7. Delete Invoice by ID");
//        System.out.println("8. Show All Invoices");
//        System.out.println("9. Show all Customers");
        System.out.println("10. Show all Rooms");
        System.out.println("11. Exit");
        return sc.nextInt();
    }
    public void menuProgram(Scanner sc) {
        boolean isExit = true;
        while (isExit) {

            switch (printMenu(sc)) {
                case 1:
                    roomController.createRoom(sc);
                    break;

                case 2:
                    roomController.updateRoom(sc);
                    break;
//
//                case 3:
//                    break;
//
//                case 4:
//
//                    break;
//
//                case 5:
//                    break;
//                case 6:
//                    break;
//
//                case 7:

//                    break;
//
//                case 8:

//                    break;
//
//                case 9:

//                    break;

                case 10:
                    roomController.getAllRooms();
                    break;
                case 11:
                    isExit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
