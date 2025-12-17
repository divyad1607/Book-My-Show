package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByMobNo(String mobNo);
}
