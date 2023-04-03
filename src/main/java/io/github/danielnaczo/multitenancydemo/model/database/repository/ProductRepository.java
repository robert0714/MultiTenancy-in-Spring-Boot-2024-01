package io.github.danielnaczo.multitenancydemo.model.database.repository;

import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
