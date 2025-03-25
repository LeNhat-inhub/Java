package controller;

import constant.Common;
import object.Customer;
import service.CustomerService;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerController {
    public CustomerService customerService;
    public CustomerController() {
        this.customerService = new CustomerService();
    }

    public Customer createCustomer(Scanner sc) {

        Customer tempCustomer = new Customer();
        Common.clearBuffer(sc);
        System.out.println("Enter customer name: ");
        tempCustomer.setName(sc.nextLine());
        System.out.println("Enter customer phone: ");
        tempCustomer.setPhone(sc.nextLine());
        System.out.println("Enter customer identity number: ");
        tempCustomer.setIdentityNumber(sc.nextLine());
        UUID id = UUID.randomUUID();

        Customer customer = customerService.createCustomer(tempCustomer);
        return customer;
    }
    public void updateCustomer(Scanner sc) {
        Common.clearBuffer(sc);
        System.out.println("Enter customer ID: ");
        String id = sc.nextLine();
        Customer tempCustomer = customerService.findCustomerById(id);
        if (tempCustomer != null) {
            System.out.println("Enter new customer name: ");
            tempCustomer.setName(sc.nextLine());
            System.out.println("Enter new customer phone: ");
            tempCustomer.setPhone(sc.nextLine());
        }
        Customer customer = customerService.updateCustomer(id);
    }
    public void getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        if (!customerList.isEmpty()) {
            customerList.forEach(System.out::println);
        } else
            System.out.println("No customer found");
    }
}
