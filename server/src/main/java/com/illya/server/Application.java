package com.illya.server;

import com.illya.server.dto.UserDTO;
import com.illya.server.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // for development
//@SpringBootApplication

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.addUser(
                    new UserDTO(
                            1,
                            "Illya1",
                            "illya1@email.com",
                            "123",
                            "ROLE_ADMIN, ROLE_USER"));
            userService.addUser(
                    new UserDTO(
                            2,
                            "Illya2",
                            "illya2@email.com",
                            "1234",
                            "ROLE_USER"));
        };
    }
}
