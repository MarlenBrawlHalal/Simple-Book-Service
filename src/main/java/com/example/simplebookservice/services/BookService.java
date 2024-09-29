package com.example.simplebookservice.services;

import com.example.simplebookservice.handler.NotFoundException;
import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
  
  private final BookRepository bookRepository;
  
  public List<BookModel> getAllBooks() {
    return bookRepository.findAll();
  }

  public BookModel getBook(int id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Book with id: %d not found", id)));
  }

  public void createBook(BookModel book) {
    bookRepository.save(book);
  }

  public void updateBook(int id, BookModel book) {
    BookModel foundBook = bookRepository.findById(id)
        .orElseThrow(() -> new NotFoundException(String.format("Book with id: %d not found", id)));

    foundBook.setTitle(book.getTitle());
    foundBook.setAuthor(book.getAuthor());
    foundBook.setDescription(book.getDescription());
    foundBook.setPrice(book.getPrice());

    bookRepository.save(foundBook);
  }

  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }
}
