package com.Book_My_Show.Models;

import com.Book_My_Show.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ticketId;

    private String movieName;

    private LocalDate showDate;

    private LocalTime showTime;

    private String theaterNameAndAddress;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus; // BOOKED / CANCELLED

    private Integer totalAmtPaid;
    @JoinColumn
    @ManyToOne
    private Show show;

    @JoinColumn
    @ManyToOne
    private User user;
}
