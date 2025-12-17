package com.Book_My_Show.Models;

import com.Book_My_Show.Enums.SeatStatus;
import com.Book_My_Show.Enums.SeatType;
import com.Book_My_Show.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private Boolean isAvailable;

    @ManyToOne
    @JoinColumn
    private Show show;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}