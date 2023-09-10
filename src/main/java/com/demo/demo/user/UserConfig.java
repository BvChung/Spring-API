package com.demo.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {


    //   run method will be automatically executed when the application starts up
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User brandon = new User(
                    "Brandon",
                    "brandon@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 23)
            );

            User james = new User(
                    "James",
                    "james@gmail.com",
                    LocalDate.of(2001, Month.FEBRUARY, 22)
            );

            repository.saveAll(List.of(brandon, james));
        };
    }
}
