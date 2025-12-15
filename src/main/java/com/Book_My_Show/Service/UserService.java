package com.Book_My_Show.Service;

import com.Book_My_Show.Models.User;
import com.Book_My_Show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(User user){
            user = userRepository.save(user);
            return "The user has been saves to the DB with userId"+user.getUserId();

    }
}
