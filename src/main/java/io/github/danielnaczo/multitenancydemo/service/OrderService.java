package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.service.tenant.OrderPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderPersistenceService orderPersistenceService;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderPersistenceService orderPersistenceService,
                        CustomerService customerService,
                        ProductService productService) {
        this.orderPersistenceService = orderPersistenceService;
        this.customerService = customerService;
        this.productService = productService;
    }

    public void saveOrder(Order order, String productCode, String customerId) {
        Product product = this.productService.findProductByCode(productCode);
        if (product == null) {
            throw new RuntimeException("Product with code '" + productCode + "' not found in Database");
        }
        order.setProductCode(productCode);

        Customer customer = this.customerService.findCustomerByCustomerId(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer with customerId '" + customerId + "' not found in Database");
        }
        order.setCustomer(customer);
        this.orderPersistenceService.saveOrder(order);
    }
}
