package com.anh.product.utils;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CustomResponse<T> {
    private int code;
    private String message;
    private T data;
}
