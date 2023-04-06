package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect.annotation.SetTenantForTransaction;
import io.github.danielnaczo.multitenancydemo.database.service.tenant.CustomerPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.rest.dto.CustomerRequestDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerPersistenceService customerPersistenceService;
    private ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerPersistenceService customerPersistenceService) {
        this.customerPersistenceService = customerPersistenceService;
        this.modelMapper = new ModelMapper();
    }

    @SetTenantForTransaction
    @Transactional
    public void saveCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = this.modelMapper.map(customerRequestDto, Customer.class);
        Customer savedCustomer = this.customerPersistenceService.saveCustomer(customer);
        LOG.info("Saved customer: {}", savedCustomer);
    }

    public Customer findCustomerByCustomerCode(String customerCode) {
        return this.customerPersistenceService.findCustomerByCustomerCode(customerCode);
    }
}
