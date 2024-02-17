package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        if (customerRepository.findByUsername(customer.getUsername()) != null) {
            throw new IllegalArgumentException("Username already exists: " + customer.getUsername());
        }
        return customerRepository.save(customer);
    }

    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found with username: " + username);
        }
        return customer;
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String username) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            customerRepository.delete(customer);
        } else {
            throw new IllegalArgumentException("Customer not found with username: " + username);
        }
    }
}