package com.saifuddin.ecommerce.ecommerce_system.controller;

import com.saifuddin.ecommerce.ecommerce_system.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestParam Long userId) {
        return orderService.placeOrder(userId);
    }
}
