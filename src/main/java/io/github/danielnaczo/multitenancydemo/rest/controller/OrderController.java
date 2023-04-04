package io.github.danielnaczo.multitenancydemo.rest.controller;

import io.github.danielnaczo.multitenancydemo.rest.dto.OrderRequestDto;
import io.github.danielnaczo.multitenancydemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void receiveOrder(@RequestBody OrderRequestDto orderRequestDto) {
        this.orderService.saveOrder(orderRequestDto);
    }
}
