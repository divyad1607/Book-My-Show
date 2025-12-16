package com.Book_My_Show.Service;

import com.Book_My_Show.Models.User;
import com.Book_My_Show.Repository.UserRepository;
import com.Book_My_Show.Requests.LoginRequest;
import com.Book_My_Show.Requests.RegisterRequest;
import com.Book_My_Show.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(LoginRequest request) {

        User user = userRepository.findByEmailId(request.getEmailId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getEmailId());
    }

}

