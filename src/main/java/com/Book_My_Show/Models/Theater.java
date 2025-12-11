package com.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterId;

    private String name;

    private String address;

    private Integer onOfScreens;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();
}
