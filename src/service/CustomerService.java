package service;

import object.Customer;
import repo.CustomerRepo;
import java.util.Scanner;
import java.util.UUID;

public class CustomerService {
    private CustomerRepo customerRepo;

    public CustomerService() {
        this.customerRepo = new CustomerRepo();
    }

    public Customer createCustomer(Customer customer) {
        customerRepo.saveCustomer(customer);
        return customer;
    }

    public Customer updateCustomer(String id) {

        Customer customer = customerRepo.findCustomerById(id);
        customerRepo.saveCustomer(customer);
        return customer;
    }

    public boolean deleteCustomer(String id) {
        boolean isDeleted = customerRepo.deleteCustomerById(id);

        if (isDeleted) {
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer with ID " + id + " not found.");
        }

        return isDeleted;
    }

    public Customer findCustomerById(String id) {
        return customerRepo.findCustomerById(id);
    }
}
