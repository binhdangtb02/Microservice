package com.example.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseObject {
    private HttpStatus httpStatus;
    private Object data;
    private String message;
}
