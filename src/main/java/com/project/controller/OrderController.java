package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Order;
import com.project.model.OrderRequestDto;
import com.project.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/{userId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long userId, @RequestBody OrderRequestDto orderRequest) {
        Order order = orderService.createOrder(userId, orderRequest);
        if (order == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(order);
    }

    // Other order-related handler methods
}
