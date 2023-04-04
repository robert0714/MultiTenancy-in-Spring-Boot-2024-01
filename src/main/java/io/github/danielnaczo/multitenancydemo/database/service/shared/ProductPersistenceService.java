package io.github.danielnaczo.multitenancydemo.database.service.shared;

import io.github.danielnaczo.multitenancydemo.database.repository.ProductRepository;
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

    public Product findProductByCode(String productCode) {
        return this.productRepository.findProductByCode(productCode);
    }
}
