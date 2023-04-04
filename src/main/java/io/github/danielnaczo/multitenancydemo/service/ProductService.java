package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.service.shared.ProductPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import io.github.danielnaczo.multitenancydemo.rest.dto.ProductRequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductPersistenceService productPersistenceService;

    @Autowired
    public ProductService(ProductPersistenceService productPersistenceService) {
        this.productPersistenceService = productPersistenceService;
    }

    public void saveProduct(ProductRequestDto productRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Product product = modelMapper.map(productRequestDto, Product.class);
        this.productPersistenceService.saveProduct(product);
    }

    public Product findProductByCode(String productCode) {
        return this.productPersistenceService.findProductByCode(productCode);
    }
}
