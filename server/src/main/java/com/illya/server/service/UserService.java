package com.illya.server.service;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.entity.User;
import com.illya.server.payload.response.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface UserService extends UserDetailsService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

    Iterable<User> findAll();

    Optional<User> findByUsername(String username);
}
