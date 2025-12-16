package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Show;
import com.Book_My_Show.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat ,Integer> {
    List<ShowSeat>findAllByShow(Show show); //Inbuilt method invoking

    //custom JPL Query
    @Query(nativeQuery = true,value = "select * from show_seats where show_id = :showId")
    public List<ShowSeat> findShowSeats(Integer showId);

    List<ShowSeat> findByTicketTicketId(String ticketId);
}
