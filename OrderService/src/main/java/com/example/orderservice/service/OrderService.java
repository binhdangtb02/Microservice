package com.example.orderservice.service;

import com.example.orderservice.dto.OrderLineItems;
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
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    @Transactional

    public Order placeOrder(Order order){

            List<String>  skuCodes = order.getOrderLineItemList().stream()
                    .map(OrderLineItem::getSkucode)
                    .toList();
            Boolean result = webClientBuilder.build().get()
                    .uri("http://inventory-service/api/inventory" ,
                            uriBuilder -> uriBuilder.queryParam("sku-code", skuCodes).build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
            if(result){
                Order order1 = orderRepository.save(order);
                return order1;
            }
            else{
                throw new IllegalArgumentException("Product is not in stock ...  try again");
            }


    }
}
