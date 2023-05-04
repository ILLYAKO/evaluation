package com.illya.server.controller;

import org.springframework.web.bind.annotation.*;

@RestController // REST API
@CrossOrigin  // for connect to the front end application
@RequestMapping("api/vi/user") // url of request

public class UserController {

    @PostMapping("/save") // Annotation for mapping HTTP POST requests onto specific handler methods
    public String saveUser(@RequestBody User userDTO){
        String id =userService.addUser(userDTO);
        return id;
    }

}
