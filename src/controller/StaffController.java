package controller;

import constant.Common;
import object.Staff;
import service.StaffService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class StaffController {
    public StaffService staffService;
    public StaffController() {
        this.staffService = new StaffService();
    }

    public void createStaff(Scanner sc) {
        Staff tempStaff = new Staff();
        Common.clearBuffer(sc);
        System.out.println("Enter Staff Identity Number: ");
        tempStaff.setIdentityNumber(sc.nextLine());
        System.out.println("Enter staff name: ");
        tempStaff.setName(sc.nextLine());
        UUID id = UUID.randomUUID();

        Staff staff = staffService.createStaff(tempStaff);

    }
    public void getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        if (!staffList.isEmpty()) {
            staffList.forEach(System.out::println);
        } else
            System.out.println("No staff found");
    }

}
