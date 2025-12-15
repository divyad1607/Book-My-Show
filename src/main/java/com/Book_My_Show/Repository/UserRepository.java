package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findUserByMobileNo(String mobileNo);
}
