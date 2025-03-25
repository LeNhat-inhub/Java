package object;

import java.io.Serializable;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


public class RoomManagement implements Serializable {
    private Customer customer;
    private Staff staff;
    private LocalDate date;
    private LocalDate startTime;
    private LocalDate endTime;
    private RoomManagementDetail roomManagementDetail;
    private List<RoomManagementDetail> roomManagementDetailList;

    public RoomManagement() {}


    public RoomManagement(Customer customer, Staff staff, LocalDate date, List<RoomManagementDetail> roomManagementDetailList, LocalDate startTime, LocalDate endTime, RoomManagementDetail roomManagementDetail) {
        this.customer = customer;
        this.staff = staff;
        this.date = date;
        this.roomManagementDetailList = new ArrayList<>(roomManagementDetailList);
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomManagementDetail = roomManagementDetail;
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

    public RoomManagementDetail getRoomManagementDetail() {
        return roomManagementDetail;
    }

    public void setRoomManagementDetail(RoomManagementDetail roomManagementDetail) {
        this.roomManagementDetail = roomManagementDetail;
    }

    public void setRoomManagementDetailList(List<RoomManagementDetail> roomManagementDetailList) {
        this.roomManagementDetailList = roomManagementDetailList;
    }
    public void addRoomManagementDetailList(List<RoomManagementDetail> roomManagementDetaillist) {
        this.roomManagementDetailList.addAll(roomManagementDetaillist);
    }
    public List<RoomManagementDetail> getRoomManagementDetailList() {
        if (roomManagementDetailList == null) {
            roomManagementDetailList = new ArrayList<>();
        }
        return roomManagementDetailList;
    }
    public void addRoomManagementDetail(RoomManagementDetail detail) {
        if (roomManagementDetailList == null) {
            roomManagementDetailList = new ArrayList<>();
        }
        roomManagementDetailList.add(detail);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice Details:\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Staff: ").append(staff.getName()).append("\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Start Time: ").append(startTime).append("\n");
        sb.append("End Time: ").append(endTime).append("\n");
        sb.append("Rooms:\n");

        if (roomManagementDetailList != null) {
            for (RoomManagementDetail roomManagementDetail : roomManagementDetailList) {
                sb.append(" - Room ID: ").append(roomManagementDetail.getRoom().getId())
                        .append(", Capacity: ").append(roomManagementDetail.getRoom().getCapacity())
                        .append(", Price: ").append(roomManagementDetail.getInvoicePrice())
                        .append("\n");
            }
        }else {
            sb.append("No rooms found\n");
        }
        return sb.toString();
    }
}
