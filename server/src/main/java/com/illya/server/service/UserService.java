package com.illya.server.service;

import com.illya.server.dto.UserDTO;
import org.springframework.stereotype.Service;


public interface UserService {
    String addUser(UserDTO userDTO);
}
