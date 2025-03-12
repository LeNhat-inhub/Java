package object;


import java.io.Serializable;
import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;


public class RoomManagement implements Serializable {
    private Customer customer;
    private Staff staff;
    private LocalDate date;
    private List<RoomManagementDetail> roomManagementDetailList;
    private LocalDate startTime;
    private LocalDate endTime;
    public RoomManagement() {}

    public RoomManagement(Customer customer, Staff staff, LocalDate date, List<RoomManagementDetail> roomManagementDetailList, LocalDate startTime, LocalDate endTime) {
        this.customer = customer;
        this.staff = staff;
        this.date = date;
        this.roomManagementDetailList = roomManagementDetailList;
        this.startTime = startTime;
        this.endTime = endTime;
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
    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }
    public List<RoomManagementDetail> getRoomManagementDetailList() {
        return roomManagementDetailList;
    }

    public void setRoomManagementDetailList(List<RoomManagementDetail> roomManagementDetailList) {
        this.roomManagementDetailList = roomManagementDetailList;
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

        for (Room room : roomManagementDetailList) {
            sb.append(" - Room ID: ").append(room.getId())
                    .append(", Capacity: ").append(room.getCapacity())
                    .append(", Price: ").append(room.getPrice())
                    .append(", Status: ").append(room.getStatus()).append("\n");
        }

        return sb.toString();
    }
}
