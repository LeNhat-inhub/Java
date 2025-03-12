package controller;

import object.Staff;
import service.StaffService;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class StaffController {
    public StaffService staffService;
    public StaffController() {
        this.staffService = new StaffService();
    }

    public void createStaff(Scanner sc) {
        Staff tempStaff = new Staff();
        sc.nextLine();
        System.out.println("Enter staff name: ");
        tempStaff.setName(sc.nextLine());
        UUID id = UUID.randomUUID();

        Staff staff = staffService.createStaff(tempStaff);

    }

}
