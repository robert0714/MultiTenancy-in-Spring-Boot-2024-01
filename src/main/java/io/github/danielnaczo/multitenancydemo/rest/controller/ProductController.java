package io.github.danielnaczo.multitenancydemo.rest.controller;

import io.github.danielnaczo.multitenancydemo.rest.dto.ProductRequestDto;
import io.github.danielnaczo.multitenancydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void receiveProduct(@RequestBody ProductRequestDto productRequestDto) {
        this.productService.saveProduct(productRequestDto);
    }
}
