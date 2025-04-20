package com.example.Library_Management_System.service;


import com.example.Library_Management_System.model.entity.Book;
import com.example.Library_Management_System.model.entity.User;
import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long bookId);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthor(User author);
    Book updateBook(Book book);
    void deleteBook(Long bookId);
}