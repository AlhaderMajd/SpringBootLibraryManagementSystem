package com.example.Library_Management_System.service;

import com.example.Library_Management_System.repository.UserRepository;
import com.example.Library_Management_System.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
//        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setUserPassword(user.getUserPassword());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        if (user.getUserPassword() != null) {
//            user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
            user.setUserPassword(user.getUserPassword());
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName)
                .orElse(null);
    }
}