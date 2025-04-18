package com.example.Library_Management_System.dao;

import com.example.Library_Management_System.entity.Book;
import com.example.Library_Management_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(User author);
    List<Book> findAll();
}