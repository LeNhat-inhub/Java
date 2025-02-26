package service;

import object.Customer;
import repo.CustomerRepo;
import java.util.Scanner;
import java.util.UUID;

public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public static Customer createCustomer() {
        CustomerRepo customerRepo = new CustomerRepo();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.println("Enter customer identity number: ");
        String identityNumber = scanner.nextLine();

        System.out.println("Enter customer phone number: ");
        String phone = scanner.nextLine();

        UUID id = UUID.randomUUID();
        Customer customer = new Customer(id, name, identityNumber, phone);
        customerRepo.saveCustomer(customer);

        return customer;
    }

    public Customer updateCustomer(UUID id) {
        Scanner scanner = new Scanner(System.in);

        Customer customer = customerRepo.findCustomerById(id);
        if (customer == null) {
            System.out.println("Customer with ID " + id + " not found.");
            return null;
        }

        System.out.println("Update customer name: ");
        String name = scanner.nextLine();
        customer.setName(name);

        System.out.println("Update customer identity number: ");
        String identityNumber = scanner.nextLine();
        customer.setIdentityNumber(identityNumber);

        System.out.println("Update customer phone number: ");
        String phone = scanner.nextLine();
        customer.setPhone(phone);

        customerRepo.saveCustomer(customer);
        System.out.println("Customer updated successfully!");

        return customer;
    }

    public boolean deleteCustomer(UUID id) {
        boolean isDeleted = customerRepo.deleteCustomerById(id);

        if (isDeleted) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }

        return isDeleted;
    }

    public Customer findCustomerById(UUID id) {
        return customerRepo.findCustomerById(id);
    }
}
