package com.example.Library_Management_System.security;

import com.example.Library_Management_System.dao.RoleRepository;
import com.example.Library_Management_System.dao.UserRepository;
import com.example.Library_Management_System.entity.Role;
import com.example.Library_Management_System.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Check if roles exist, if not create them
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setRoleName("ADMIN");
            roleRepository.save(adminRole);

            Role authorRole = new Role();
            authorRole.setRoleName("AUTHOR");
            roleRepository.save(authorRole);

            Role memberRole = new Role();
            memberRole.setRoleName("MEMBER");
            roleRepository.save(memberRole);

            logger.info("Default roles created");
        }

        // Check if admin user exists, if not create it
        createUserIfNotExists("admin", "admin@library.com", "admin123", "ADMIN");
        createUserIfNotExists("author", "author@library.com", "author123", "AUTHOR");
        createUserIfNotExists("member", "member@library.com", "member123", "MEMBER");
        createUserIfNotExists("majdAdmin", "majdAdmin@library.com", "majdAdmin123", "ADMIN");
    }

    private void createUserIfNotExists(String username, String email, String password, String roleName) {
        if (userRepository.findByUserName(username).isEmpty()) {
            User user = new User();
            user.setUserName(username);
            user.setUserEmail(email);
            user.setUserPassword(passwordEncoder.encode(password));

            // If your User entity has an enabled field
            // user.setEnabled(true); // Uncomment if you have this field

            Role role = roleRepository.findByRoleName(roleName)
                    .orElseThrow(() -> new RuntimeException(roleName + " role not found"));
            user.setRole(role);

            userRepository.save(user);
            logger.info("Created user: {}", username);
        }
    }
}