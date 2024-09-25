package com.example.simplebookservice.controllers;

import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
  
  private final BookService bookService;
  
  @GetMapping
  public ResponseEntity<List<BookModel>> getAllBooks() {
    return bookService.getAllBooks();
  }
}
