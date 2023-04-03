package io.github.danielnaczo.multitenancydemo.model.database.service.shared;

import io.github.danielnaczo.multitenancydemo.model.database.repository.ProductRepository;
import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPersistenceService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductPersistenceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }
}
