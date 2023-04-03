package io.github.danielnaczo.multitenancydemo.model.database.service.tenant;

import io.github.danielnaczo.multitenancydemo.model.database.repository.OrderRepository;
import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderPersistenceService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderPersistenceService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.save(order);
    }
}
