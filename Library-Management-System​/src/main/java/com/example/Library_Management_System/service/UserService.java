package com.example.Library_Management_System.service;

import com.example.Library_Management_System.model.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long userId);
    User findByUserName(String userName);  // Changed from findByName to findByUserName
}