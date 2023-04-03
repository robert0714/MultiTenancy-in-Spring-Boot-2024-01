package io.github.danielnaczo.multitenancydemo.database.repository;

import io.github.danielnaczo.multitenancydemo.model.tenant.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
