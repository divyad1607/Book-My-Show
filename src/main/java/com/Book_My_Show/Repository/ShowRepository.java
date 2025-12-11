package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Integer> {
}
