package com.demo.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

        public void createUser(User user) {
            Optional<User> optionalUser = userRepository.findUserByEmail(user.getEmail());
            if (optionalUser.isPresent()) {
                throw new IllegalStateException("User with email already exists.");
            }
            userRepository.save(user);
            System.out.println(user);
        }

        public void deleteUser(Long userId) {
            if (!userRepository.existsById(userId)){
                throw new IllegalStateException("User with " + userId + " does not exist.");
            }

            userRepository.deleteById(userId);
        }
}
