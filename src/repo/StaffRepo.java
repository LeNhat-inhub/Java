package repo;

import constant.Common;
import object.Staff;

import java.util.List;

public class StaffRepo {
    private List<Staff> staffs;
    public StaffRepo() {
        staffs = Common.getReadWriteObject().read(Common.staffPath, Staff.class);
    }

    public void saveStaff(Staff staff) {
        Common.getReadWriteObject().write(staff,Common.staffPath);
        staffs.add(staff);
    }

    public Staff findStaffById(String id) {
        for (Staff staff : staffs) {
            if (staff.getIdentityNumber().equals(id)) {
                return staff;
            }
        }
        return null;
    }
    public List<Staff> getAllStaff() {return staffs;}

}
