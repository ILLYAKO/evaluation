package com.illya.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API
//@CrossOrigin(origins = "http://localhost:4200")   // for connect to the front end application


public class HomeController {

    @GetMapping()
    public String home() {
        return "Hello from Home Evaluation API!!!";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/user")
    public String user() {
        return "Hello from User.";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Hello from Admin.";
    }
}
