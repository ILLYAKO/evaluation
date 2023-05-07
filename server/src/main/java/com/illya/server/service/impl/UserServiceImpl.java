package com.illya.server.service.impl;

import com.illya.server.dto.LoginDTO;
import com.illya.server.dto.UserDTO;
import com.illya.server.entity.User;
import com.illya.server.payload.response.LoginResponse;
import com.illya.server.repository.UserRepo;
import com.illya.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg ="";
        User candidate = userRepo.findByEmail(loginDTO.getEmail());
        if (candidate != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = candidate.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password,encodedPassword);
            if(isPasswordRight){
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if(user.isPresent()){
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            }else {
                return new LoginResponse("Password not match", false);
            }

        } else {
            return new LoginResponse("Email not exist", false);
        }
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }
}
