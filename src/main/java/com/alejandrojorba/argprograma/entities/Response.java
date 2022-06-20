package com.alejandrojorba.argprograma.entities;

import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public @Data class Response<T> {
    T data;
    String message;
}
