package com.example.simplebookservice.controllers;

import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.services.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
  
  private final BookService bookService;

  @Tag(name = "Get", description = "Get methods of Book service API")
  @GetMapping
  public ResponseEntity<List<BookModel>> getAllBooks() {
    return bookService.getAllBooks();
  }

  @Tag(name = "Get", description = "Get methods of Book service API")
  @GetMapping("/{id}")
  public ResponseEntity<BookModel> getBook(@PathVariable int id) {
    return bookService.getBook(id);
  }

  @Tag(name = "Post", description = "Post methods of Book service API")
  @PostMapping
  public void createBook(@RequestBody BookModel book) {
    bookService.createBook(book);
  }

  @Tag(name = "Put", description = "Put methods of Book service API")
  @PutMapping("/{id}")
  public void updateBook(@PathVariable int id, @RequestBody BookModel book) {
    bookService.updateBook(id, book);
  }

  @Tag(name = "Delete", description = "Delete methods of Book service API")
  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
  }
}
