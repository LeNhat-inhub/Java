package repo;

import object.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepo {
    private List<Customer> customers;

    public CustomerRepo() {
        customers = new ArrayList<>();
    }

    public void saveCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer saved successfully!");
    }

    public Customer findCustomerById(UUID id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public boolean deleteCustomerById(UUID id) {
        Customer customer = findCustomerById(id);
        if (customer != null) {
            customers.remove(customer);
            return true;
        }
        return false;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}