package com.example.simplebookservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ExceptionResponse> handleException(NotFoundException exp) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(
            ExceptionResponse.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .errorDescription("Not found")
                .error(exp.getMessage())
                .build()
        );
  }
}
