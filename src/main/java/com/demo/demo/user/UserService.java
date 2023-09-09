package com.demo.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

// Layer to perform business logic
@Service
public class UserService {
        private final UserRepository userRepository;

        @Autowired
        UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public List<User> getUsers() {
            return this.userRepository.findAll();
        }
}
