package service;

import object.Room;
import object.RoomAvailable;
import object.RoomManagement;
import object.RoomManagementDetail;
import repo.RoomManagementRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class RoomManagementService {
    private RoomManagementRepo roomManagementRepo;
    private RoomManagement roomManagement;
    List<RoomManagement> availableRooms;
    List<RoomManagementDetail> roomManagementDetails;
    List<Room> rooms;
    public RoomManagementService() {
        this.roomManagementRepo = new RoomManagementRepo();
        this.roomManagement = new RoomManagement();
    }
//
//    public void availableRoomNow () {
//        List<Room> availableRooms = new ArrayList<>(rooms);
//        List<RoomManagementDetail> reserveRoom = new ArrayList<>(roomManagementDetails);
//        List<Room> remainingRooms = new ArrayList<>(availableRooms);
//        for(RoomManagementDetail room : reserveRoom) {
//            if(isExpired()){
//                availableRooms.add(room.getRoom());
//                remainingRooms.remove(room.getRoom());
//            }
//        }
//    }
    public RoomManagement createInvoice(RoomManagement roomManagement) {
        if (roomManagement.getStartTime().isAfter(roomManagement.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
        roomManagementRepo.saveRoomManagement(roomManagement);
        return roomManagement;
    }
    public boolean isExpired() {
        return LocalDate.now().isAfter(roomManagement.getEndTime());
    }
    public List<RoomManagement> getAllManagement() {
        return roomManagementRepo.getAllRoomManagements();
    }


}