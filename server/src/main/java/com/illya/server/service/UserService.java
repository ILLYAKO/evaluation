package com.illya.server.service;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.entity.User;
import com.illya.server.payload.response.LoginResponse;
import org.springframework.stereotype.Service;


public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

    Iterable<User> findAll();
}
