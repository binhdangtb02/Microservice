package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ResponseObject;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private final ProductRepository    productRepository;
    @PostMapping
    public ResponseEntity<ResponseObject> createProduct(@RequestBody ProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        return ResponseEntity.ok().body(new ResponseObject(HttpStatus.OK, product, "Successfully"));
    }
    @GetMapping
    public ResponseEntity<ResponseObject> getAllProduct(){
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok().body(new ResponseObject(HttpStatus.OK, products, "Successfully"));
    }


}
