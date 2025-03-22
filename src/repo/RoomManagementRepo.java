package repo;

import constant.Common;
import object.RoomManagement;
import object.RoomManagementDetail;

import java.util.List;

public class RoomManagementRepo {
    private List<RoomManagement> roomManagements;
    public RoomManagementRepo() {
        roomManagements = Common.getReadWriteObject().read(Common.roomManagementPath, RoomManagement.class);
    }
    public void saveRoomManagement(RoomManagement roomManagement) {
        Common.getReadWriteObject().write(roomManagement, Common.roomManagementPath);
        roomManagements.add(roomManagement);
    }

    public List<RoomManagement> getAllRoomManagements() {
        return roomManagements;
    }
}