package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Movie;
import com.Book_My_Show.Models.Show;
import com.Book_My_Show.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowRepository extends JpaRepository<Show,Integer> {
    public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate,
                                                                LocalTime showTime,
                                                                Movie movie,
                                                                Theater theater);

}
