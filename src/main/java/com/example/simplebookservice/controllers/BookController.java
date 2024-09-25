package com.example.simplebookservice.controllers;

import com.example.simplebookservice.handler.NotFoundException;
import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public ResponseEntity<BookModel> getBook(@PathVariable int id) {
    return bookService.getBook(id);
  }

  @PostMapping
  public void createBook(@RequestBody BookModel book) {
    bookService.createBook(book);
  }

  @PutMapping("/{id}")
  public void updateBook(@PathVariable int id, @RequestBody BookModel book) {
    bookService.updateBook(id, book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
  }
}
