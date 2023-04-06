package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import io.github.danielnaczo.multitenancydemo.rest.dto.OrderRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderTransactionService orderTransactionService;
    private final CustomerService customerService;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderTransactionService orderTransactionService,
                        CustomerService customerService,
                        ProductService productService) {
        this.orderTransactionService = orderTransactionService;
        this.customerService = customerService;
        this.productService = productService;
    }

    public void processOrder(OrderRequestDto orderRequestDto) {
        Product product = this.productService.findProductByCode(orderRequestDto.getProductCode());
        if (product == null) {
            throw new RuntimeException("Product with code '" + orderRequestDto.getProductCode() + "' not found in Database");
        }
        Order order = new Order();
        order.setProductCode(orderRequestDto.getProductCode());

        Customer customer = this.customerService.findCustomerByCustomerCode(orderRequestDto.getCustomerCode());
        if (customer == null) {
            throw new RuntimeException("Customer with customerCode '" + orderRequestDto.getCustomerCode() + "' not found in Database");
        }
        order.setCustomer(customer);
        order.setOrderDateTime(orderRequestDto.getOrderDateTime());
        this.orderTransactionService.saveOrder(order);
    }
}
