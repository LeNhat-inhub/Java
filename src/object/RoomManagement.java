package object;

import service.RoomManagementService;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RoomManagement implements Serializable {
    private Customer customer;
    private Staff staff;
    private LocalDate date;
    private List<Room> roomList;
    private RoomManagementService roomManagementService;

    // Constructor
    public RoomManagement(Customer customer, Staff staff, LocalDate date, List<Room> roomList, RoomManagementService roomManagementService) {
        this.customer = customer;
        this.staff = staff;
        this.date = date;
        this.roomList = roomList;
        this.roomManagementService = roomManagementService;
    }

    // Getters and Setters
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

    // Methods to manage rooms through RoomManagementService
    public Room findRoomById(String id) {
        return roomManagementService.findRoomById(id);
    }

    // Methods to manage invoices through RoomManagementService
    public void createInvoice(Customer customer, Staff staff, List<Room> rooms, double totalAmount) {
        roomManagementService.createInvoice(customer, staff, rooms, totalAmount);
    }

    public RoomManagementService.InvoiceData findInvoiceById(UUID id) {
        return roomManagementService.findInvoiceById(id);
    }

    public boolean deleteInvoiceById(UUID id) {
        return roomManagementService.deleteInvoiceById(id);
    }

    public List<RoomManagementService.InvoiceData> getAllInvoices() {
        return roomManagementService.getAllInvoices();
    }

    // Override toString to print invoice details
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Details:\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Staff: ").append(staff.getName()).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Rooms:\n");

        for (Room room : roomList) {
            sb.append(" - Room ID: ").append(room.getId())
                    .append(", Capacity: ").append(room.getCapacity())
                    .append(", Price: ").append(room.getPrice())
                    .append(", Status: ").append(room.getStatus()).append("\n");
        }

        return sb.toString();
    }
    String url = "./src/data/room-management.bin";
}
