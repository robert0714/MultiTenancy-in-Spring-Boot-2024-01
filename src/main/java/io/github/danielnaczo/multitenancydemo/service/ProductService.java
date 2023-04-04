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
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductPersistenceService productPersistenceService) {
        this.productPersistenceService = productPersistenceService;
        this.modelMapper = new ModelMapper();
    }

    public void saveProduct(ProductRequestDto productRequestDto) {
        Product product = this.modelMapper.map(productRequestDto, Product.class);
        this.productPersistenceService.saveProduct(product);
    }

    public Product findProductByCode(String productCode) {
        return this.productPersistenceService.findProductByCode(productCode);
    }
}
