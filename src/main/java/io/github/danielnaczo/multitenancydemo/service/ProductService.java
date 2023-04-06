package io.github.danielnaczo.multitenancydemo.service;

import io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect.annotation.SetDefaultForTransaction;
import io.github.danielnaczo.multitenancydemo.database.service.shared.ProductPersistenceService;
import io.github.danielnaczo.multitenancydemo.model.shared.Product;
import io.github.danielnaczo.multitenancydemo.rest.dto.ProductRequestDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    private final ProductPersistenceService productPersistenceService;
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductPersistenceService productPersistenceService) {
        this.productPersistenceService = productPersistenceService;
        this.modelMapper = new ModelMapper();
    }

    @SetDefaultForTransaction
    @Transactional
    public void saveProduct(ProductRequestDto productRequestDto) {
        Product product = this.modelMapper.map(productRequestDto, Product.class);
        Product savedProduct = this.productPersistenceService.saveProduct(product);
        LOG.info("Saved product: {}", savedProduct);
    }

    public Product findProductByCode(String productCode) {
        return this.productPersistenceService.findProductByCode(productCode);
    }
}
