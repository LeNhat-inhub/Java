package repo;

import constant.Common;
import object.Customer;
import object.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffRepo {
    private List<Staff> staffs;
    public StaffRepo() {
        staffs = Common.getReadWriteObject().read(Common.staffPath, Staff.class);
    }

    public void saveStaff(Staff staff) {
        Common.getReadWriteObject().write(staff,Common.staffPath);
        staffs.add(staff);
    }

    public Staff findStaffById(UUID id) {
        for (Staff staff : staffs) {
            if (staff.getId().equals(id)) {
                return staff;
            }
        }
        return null;
    }

}
