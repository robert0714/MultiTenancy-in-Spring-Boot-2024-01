package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.service.tenant.CustomerPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.rest.dto.CustomerRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerPersistenceService customerPersistenceService;

    @Autowired
    public CustomerService(CustomerPersistenceService customerPersistenceService) {
        this.customerPersistenceService = customerPersistenceService;
    }

    public void saveCustomer(CustomerRequestDto customerRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerRequestDto, Customer.class);
        this.customerPersistenceService.saveCustomer(customer);
    }

    public Customer findCustomerByCustomerId(String customerId) {
        return this.customerPersistenceService.findCustomerByCustomerId(customerId);
    }
}
