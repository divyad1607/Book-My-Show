package com.Book_My_Show.Controller;

import com.Book_My_Show.Requests.LoginRequest;
import com.Book_My_Show.Requests.RegisterRequest;
import com.Book_My_Show.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        String response = userService.register(request);
        return response;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String result = userService.login(request);
        return result;
    }
}

