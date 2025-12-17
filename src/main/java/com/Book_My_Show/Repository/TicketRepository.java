package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
