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
        return customerRepository.save(customer);
    }


    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }


    public Customer updateCustomer(Customer customer) {

        return customerRepository.save(customer);

    }

    public void deleteCustomer(String username) {
        Customer customer = (Customer) customerRepository.findByUsername(username);
        if (customer != null) {
            customerRepository.delete(customer);
        } else {
            throw new RuntimeException("Customer not found with username: " + username);
        }
    }
}