package com.tong.springbootmall.controller;

import com.tong.springbootmall.dto.CreatedOrderList;
import com.tong.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * ClassName: OrderController
 * Package: com.tong.springbootmall.controller
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreatedOrderList createdOrderList) {
        Integer orderId = orderService.createOrder(userId, createdOrderList);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);

    }
}
