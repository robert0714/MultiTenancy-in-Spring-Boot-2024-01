package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect.annotation.SetTenantForTransaction;
import io.github.danielnaczo.multitenancydemo.database.service.tenant.OrderPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderTransactionService {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTransactionService.class);

    private final OrderPersistenceService orderPersistenceService;

    @Autowired
    public OrderTransactionService(OrderPersistenceService orderPersistenceService) {
        this.orderPersistenceService = orderPersistenceService;
    }

    @SetTenantForTransaction
    @Transactional
    public void saveOrder(Order order) {
        Order savedOrder = this.orderPersistenceService.saveOrder(order);
        LOG.info("Saved order: {}", savedOrder);
    }
}
