package com.illya.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // for development
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
