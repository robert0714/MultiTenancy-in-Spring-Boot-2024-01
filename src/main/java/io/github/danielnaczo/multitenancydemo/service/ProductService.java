package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.service.shared.ProductPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductPersistenceService productPersistenceService;

    @Autowired
    public ProductService(ProductPersistenceService productPersistenceService) {
        this.productPersistenceService = productPersistenceService;
    }

    public void saveProduct(Product product) {
        this.productPersistenceService.saveProduct(product);
    }
}
