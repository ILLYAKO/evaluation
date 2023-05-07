package com.illya.server.controller;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.payload.response.LoginResponse;
import com.illya.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // REST API
@CrossOrigin(origins = "http://localhost:4200")   // for connect to the front end application
@RequestMapping("/") // url of request

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello from Evaluation API!!!";
    }






}
