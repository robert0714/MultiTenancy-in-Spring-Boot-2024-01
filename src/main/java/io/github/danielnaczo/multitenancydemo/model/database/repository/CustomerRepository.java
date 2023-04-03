package io.github.danielnaczo.multitenancydemo.model.database.repository;

import io.github.danielnaczo.multitenancydemo.model.tenant.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
