import object.*;
import repo.*;
import service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        RoomRepo roomRepo = new RoomRepo();
        RoomService roomService = new RoomService(roomRepo);
        RoomManagementService roomManagementService = new RoomManagementService(roomRepo);
        CustomerService customerService = new CustomerService(new CustomerRepo());

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add Room");
            System.out.println("2. Find Room by ID");
            System.out.println("3. Create Customer");
            System.out.println("4. Create Staff");
            System.out.println("5. Create Invoice");
            System.out.println("6. Find Invoice by ID");
            System.out.println("7. Delete Invoice by ID");
            System.out.println("8. Show All Invoices");
            System.out.println("9. Show all Customers");
            System.out.println("10. Show all Rooms");
            System.out.println("11. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
//                    roomManagementService.addRoom();
                    break;

                case 2:
                    System.out.println("Enter Room ID:");
                    String roomId = scanner.nextLine();
                    Room room = roomManagementService.findRoomById(roomId);
                    if (room != null) {
                        System.out.println("Room found: " + room);
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;

                case 3:
                    roomManagementService.addCustomer();
                    break;

                case 4:
                    Staff staff = roomManagementService.createStaff();
                    break;

                case 5:
                    roomManagementService.createInvoice();
                break;
                case 6:
                    System.out.println("Enter Invoice ID:");
                    UUID invoiceId = UUID.fromString(scanner.nextLine());
                    RoomManagementService.InvoiceData invoice = roomManagementService.findInvoiceById(invoiceId);
                    if (invoice != null) {
                        System.out.println("Invoice found: " + invoice);
                    } else {
                        System.out.println("Invoice not found.");
                    }
                    break;

                case 7:
                    System.out.println("Enter Invoice ID to delete:");
                    UUID deleteInvoiceId = UUID.fromString(scanner.nextLine());
                    boolean isDeleted = roomManagementService.deleteInvoiceById(deleteInvoiceId);
                    if (isDeleted) {
                        System.out.println("Invoice deleted successfully.");
                    } else {
                        System.out.println("Invoice not found.");
                    }
                    break;

                case 8:
                    List<RoomManagementService.InvoiceData> invoices = roomManagementService.getAllInvoices();
                    for (RoomManagementService.InvoiceData inv : invoices) {
                        System.out.println(inv);
                    }
                    break;

                case 9:
                    for(Customer Customers: customers){
                        System.out.println(""+ Customers.toString());
                    }
                    break;

                case 10:
                    for(Room Rooms: rooms){
                        System.out.println(""+ Rooms.toString());
                    }
                case 11:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
