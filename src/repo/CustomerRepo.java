package repo;

import constant.Common;
import object.Customer;
import object.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepo {
    private List<Customer> customers;

    public CustomerRepo() {
        customers = Common.getReadWriteObject().read(Common.customerPath, Customer.class);
    }

    public void saveCustomer(Customer customer) {
        Common.getReadWriteObject().write(customer,Common.customerPath);
        customers.add(customer);
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getIdentityNumber().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public boolean deleteCustomerById(String id) {
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