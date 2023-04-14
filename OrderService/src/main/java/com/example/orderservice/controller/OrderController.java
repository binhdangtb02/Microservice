package com.example.orderservice.controller;

import com.example.orderservice.dto.ResponseObject;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<ResponseObject> createOrder(@RequestBody Order order){
        Order order1= orderService.placeOrder(order);
        return ResponseEntity.ok().body(new ResponseObject(HttpStatus.OK, order1, "Successfully"));
    }
}
