package service;

import object.Customer;
import object.Room;
import object.RoomManagement;
import object.Staff;
import repo.RoomRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class RoomManagementService {
    private RoomRepo roomRepo;
    private List<InvoiceData> invoices;
    private List<Customer> customers;
    private List<Staff> staffList;

    // Constructor
    public RoomManagementService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
        this.invoices = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    // Methods to interact with the user for room management
    public void addRoom() {
        RoomService.createRoom();
    }

    public Room findRoomById(String id) {
        return roomRepo.findRoomById(id);
    }

    // Methods to interact with the user for customer management
    public void addCustomer() {
        CustomerService.createCustomer();
    }

    // Methods to interact with the user for staff management
    public Staff createStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter staff name: ");
        String name = scanner.nextLine();

        UUID id = UUID.randomUUID();
        Staff staff = new Staff(id, name);

        System.out.println("Staff created successfully!");

        return staff;
    }

    // Methods to manage invoices
    public void createInvoice(Customer customer, Staff staff,List<Room> rooms, double totalAmount) {
        Scanner scanner = new Scanner(System.in);

        // Check and get customer
        System.out.println("Enter customer ID: ");
        UUID customerId = UUID.fromString(scanner.nextLine());
        customer = null;
        for (Customer c : customers) {
            if (c.getId().equals(customerId)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }

        // Check and get staff
        System.out.println("Enter staff ID: ");
        UUID staffId = UUID.fromString(scanner.nextLine());
        staff = null;
        for (Staff s : staffList) {
            if (s.getId().equals(staffId)) {
                staff = s;
                break;
            }
        }

        if (staff == null) {
            System.out.println("Staff not found.");
            return;
        }

        // Check and get rooms
        rooms = new ArrayList<>();
        while (true) {
            System.out.println("Enter room ID: ");
            String roomId = scanner.nextLine();
            Room room = findRoomById(roomId);
            if (rooms != null) {
                rooms.add(room);
                System.out.println("Room added to invoice.");
            } else {
                System.out.println("Room not found.");
            }

            System.out.println("Do you want to add another room? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Calculate total amount (for demonstration, using a fixed amount here)
        totalAmount = rooms.size() * 100; // Example calculation

        InvoiceData invoice = new InvoiceData(customer, staff, LocalDate.now(), rooms, totalAmount);
        invoices.add(invoice);

        System.out.println("Invoice created successfully!");
    }

    public InvoiceData findInvoiceById(UUID id) {
        for (InvoiceData invoice : invoices) {
            if (invoice.getId().equals(id)) {
                return invoice;
            }
        }
        return null;
    }

    public boolean deleteInvoiceById(UUID id) {
        InvoiceData invoice = findInvoiceById(id);
        if (invoice != null) {
            invoices.remove(invoice);
            return true;
        }
        return false;
    }

    public List<InvoiceData> getAllInvoices() {
        return invoices;
    }

    // Inner class to handle invoice data
    public static class InvoiceData {
        private UUID id;
        private Customer customer;
        private Staff staff;
        private LocalDate date;
        private List<Room> roomList;
        private double totalAmount;

        // Constructor
        public InvoiceData(Customer customer, Staff staff, LocalDate date, List<Room> roomList, double totalAmount) {
            this.id = UUID.randomUUID();
            this.customer = customer;
            this.staff = staff;
            this.date = date;
            this.roomList = roomList;
            this.totalAmount = totalAmount;
        }

        // Getters and Setters
        public UUID getId() {
            return id;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public Staff getStaff() {
            return staff;
        }

        public void setStaff(Staff staff) {
            this.staff = staff;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public List<Room> getRoomList() {
            return roomList;
        }

        public void setRoomList(List<Room> roomList) {
            this.roomList = roomList;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }
    }
}
