package com.example.simplebookservice;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.simplebookservice.controllers.BookController;
import com.example.simplebookservice.models.BookModel;
import com.example.simplebookservice.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(BookController.class)
public class BookControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BookService bookService;

  @Test
  void getAllBooksTest() throws Exception {

    List<BookModel> mockBooks = Arrays.asList(
        new BookModel(1, "some title1", "some author1", "some description1", 123.123),
        new BookModel(2, "some title2", "some author2", "some description2", 1234.1234)
    );

    when(bookService.getAllBooks()).thenReturn(mockBooks);

    this.mockMvc.perform(get("/api/v1/books"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("some title1")))
        .andExpect(content().string(containsString("some title2")));
  }

  @Test
  void getBookByIdTest() throws Exception {

    BookModel mockBook = new BookModel(1, "some title", "some author", "some description", 123.123);

    when(bookService.getBook(1)).thenReturn(mockBook);

    this.mockMvc.perform(get("/api/v1/books/1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("some title")));
  }
}
