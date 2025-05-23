package com.example.Library_Management_System.repository;

import com.example.Library_Management_System.model.entity.Book;
import com.example.Library_Management_System.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(User author);
    List<Book> findAll();
}