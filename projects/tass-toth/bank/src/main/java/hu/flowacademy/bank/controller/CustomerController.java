package hu.flowacademy.bank.controller;


import hu.flowacademy.bank.model.Customer;
import hu.flowacademy.bank.repository.CustomerRepository;
import hu.flowacademy.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/listAll")
    public List<Customer> ListAllCustomers() {
        return customerService.listAllCustomers();
    }

    // Get customer by username
    @GetMapping("/listByUsername/{username}")
    public Customer customerListbyUsername(@PathVariable String username){
        return customerService.getCustomerByUsername(username);
    }

    // Create new customer
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    // Update existing customer
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);

    }

    // Delete customer
    @DeleteMapping("/delete/{username}")
    public void deleteCustomer(@PathVariable String username) {
        customerService.deleteCustomer(username);
    }
}