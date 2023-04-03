package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.service.tenant.OrderPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderPersistenceService orderPersistenceService;
    private final CustomerService customerService;

    @Autowired
    public OrderService(OrderPersistenceService orderPersistenceService, CustomerService customerService) {
        this.orderPersistenceService = orderPersistenceService;
        this.customerService = customerService;
    }

    public void saveOrder(Order order, String customerId) {
        Customer customer = this.customerService.findCustomerByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer with customerId '" + customerId + "' not found in Database");
        }
        order.setCustomer(customer);
        this.orderPersistenceService.saveOrder(order);
    }
}
