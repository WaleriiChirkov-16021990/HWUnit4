package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookRepository bookRepositoryMock;
    private BookService bookService;
    @BeforeEach
    void setUp() {
         bookRepositoryMock = Mockito.mock(BookRepository.class);
         bookService = new BookService(bookRepositoryMock);
    }


    @Test
    void findBookById() {
        Book book = new Book("123", "title", "author");
        Mockito.when(bookRepositoryMock.findById("123")).thenReturn(book);
        assertEquals(book, bookService.findBookById("123"));
    }

    @Test
    void findAllBooks() {
        Book book = new Book("123", "title", "author");
        Mockito.when(bookRepositoryMock.findAll()).thenReturn(List.of(book));
        assertEquals(List.of(book), bookService.findAllBooks());
    }
}