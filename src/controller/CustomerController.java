package controller;

import object.Customer;
import service.CustomerService;

import java.util.Scanner;
import java.util.UUID;

public class CustomerController {
    public CustomerService customerService;
    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public void createCustomer(Scanner sc) {

        Customer tempCustomer = new Customer();
        sc.nextLine();
        System.out.println("Enter customer name: ");
        tempCustomer.setName(sc.nextLine());
        sc.nextLine();
        System.out.println("Enter customer phone: ");
        tempCustomer.setPhone(sc.nextLine());
        sc.nextLine();
        System.out.println("Enter customer identity number: ");
        tempCustomer.setIdentityNumber(sc.nextLine());
        sc.nextLine();
        UUID id = UUID.randomUUID();

        Customer customer = customerService.createCustomer(tempCustomer);

    }
    public void updateCustomer(Scanner sc) {
        sc.nextLine();
        System.out.println("Enter customer ID: ");
        String id = sc.nextLine();
        Customer tempCustomer = customerService.findCustomerById(UUID.fromString(id));
        if (tempCustomer != null) {
            System.out.println("Enter new customer name: ");
            tempCustomer.setName(sc.nextLine());
            System.out.println("Enter new customer phone: ");
            tempCustomer.setPhone(sc.nextLine());
            System.out.println("Enter new customer identity number: ");
            tempCustomer.setIdentityNumber(sc.nextLine());
        }
        Customer customer = customerService.updateCustomer(UUID.fromString(id));
    }
}
