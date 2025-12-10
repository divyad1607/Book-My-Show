package com.Book_My_Show.Models;

import com.Book_My_Show.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theaterSeats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterSeat {
    @Id
    private Integer theaterSeatId;

    private String seatNo;

    private SeatType seatType;

    @JoinColumn
    @ManyToOne
    private Theater theater;


}
