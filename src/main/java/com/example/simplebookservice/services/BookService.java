package com.example.simplebookservice.services;

import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  
  private final BookRepository bookRepository;
  
  public ResponseEntity<List<BookModel>> getAllBooks() {
    return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
  }
}
