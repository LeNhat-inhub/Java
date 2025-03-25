package service;

import object.Room;
import object.RoomManagement;
import object.RoomManagementDetail;
import repo.RoomManagementRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;


public class RoomManagementService {
    private RoomManagementRepo roomManagementRepo;
    private RoomManagement roomManagement;
    public RoomManagementService() {
        this.roomManagementRepo = new RoomManagementRepo();
        this.roomManagement = new RoomManagement();
    }

    public RoomManagement createInvoice(RoomManagement roomManagement) {
        if (roomManagement.getStartTime().isAfter(roomManagement.getEndTime())) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }
        roomManagementRepo.saveRoomManagement(roomManagement);
        return roomManagement;
    }
    public List<RoomManagement> getAllManagement() {
        return roomManagementRepo.getAllRoomManagements();
    }

    public List<RoomManagementDetail> getAllRoomManagementDetails() {
        List<RoomManagement> allManagements = roomManagementRepo.getAllRoomManagements();
        List<RoomManagementDetail> details = new ArrayList<>();

        for (RoomManagement management : allManagements) {
            details.addAll(management.getRoomManagementDetailList());
        }

        return details;
    }


    public List<Room> getAvailableRooms(List<Room> allRooms, List<RoomManagementDetail> bookedRooms, LocalDate checkIn, LocalDate checkOut) {
        System.out.println("Booked Rooms: " + bookedRooms);

        if (bookedRooms == null || bookedRooms.isEmpty()) {
            return allRooms;
        }

        Set<String> bookedRoomIds = bookedRooms.stream()
                .filter(detail -> !(checkIn.isBefore(detail.getStartDate()) || checkOut.isAfter(detail.getEndDate())))
                .map(RoomManagementDetail::getRoomId)
                .collect(Collectors.toSet());


        if (bookedRoomIds.isEmpty()) {
            return allRooms;
        }

        return allRooms.stream()
                .filter(room -> !bookedRoomIds.contains(room.getId()))
                .collect(Collectors.toList());
    }
}