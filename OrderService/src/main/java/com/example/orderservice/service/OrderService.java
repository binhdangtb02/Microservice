package com.example.orderservice.service;

import com.example.orderservice.dto.ResponseObject;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    @Transactional
    public Order placeOrder(Order order){
        try {
            Order order1 = orderRepository.save(order);
            return order1;
        }catch (Exception ex){
            System.out.println(ex);
        }
            return null;
    }
}
