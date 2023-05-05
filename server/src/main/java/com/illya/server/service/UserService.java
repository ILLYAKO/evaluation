package com.illya.server.service;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.payload.response.LoginMessage;
import org.springframework.stereotype.Service;


public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMessage loginUser(LoginDTO loginDTO);
}
