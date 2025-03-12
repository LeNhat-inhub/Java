package service;

import object.Customer;
import object.Staff;
import repo.StaffRepo;

import java.util.UUID;

public class StaffService {
    private StaffRepo staffRepo;

    public StaffService() {
        this.staffRepo = new StaffRepo();
    }

    public Staff createStaff(Staff staff){
        staffRepo.saveStaff(staff);
        return staff;
    }
    public Staff findStaffById(UUID id) {
        return staffRepo.findStaffById(id);
    }
}
