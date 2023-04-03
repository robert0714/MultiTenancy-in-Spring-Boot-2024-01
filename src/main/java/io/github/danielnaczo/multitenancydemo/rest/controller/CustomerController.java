package io.github.danielnaczo.multitenancydemo.rest.controller;

import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    @PostMapping
    public void receiveCustomer(@RequestBody Customer customer) {
        this.customerService.saveCustomer(customer);
    }
}
