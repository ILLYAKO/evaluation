package com.illya.server.controller;

import com.illya.server.dto.UserDTO;
import com.illya.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // REST API
@CrossOrigin  // for connect to the front end application
@RequestMapping("api/v1/user") // url of request

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "Hello from Evaluation API!!!";
    }

    @PostMapping("/save") // Annotation for mapping HTTP POST requests onto specific handler methods
    public String saveUser(@RequestBody UserDTO userDTO) {
        String id = userService.addUser(userDTO);
        return id;
    }

}
