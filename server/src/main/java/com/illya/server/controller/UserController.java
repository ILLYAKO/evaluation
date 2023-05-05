package com.illya.server.controller;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.payload.response.LoginMessage;
import com.illya.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }



}
