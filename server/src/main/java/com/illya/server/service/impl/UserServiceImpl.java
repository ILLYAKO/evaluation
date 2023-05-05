package com.illya.server.service.impl;

import com.illya.server.dto.UserDTO;
import com.illya.server.entity.User;
import com.illya.server.repository.UserRepo;
import com.illya.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return null;
    }
}
