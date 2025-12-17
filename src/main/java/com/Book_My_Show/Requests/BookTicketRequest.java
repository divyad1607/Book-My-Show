package com.Book_My_Show.Requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class BookTicketRequest {

    private String movieName;

    private LocalDate showDate;

    @JsonFormat(pattern = "HH:mm:ss") // Matches the String "14:30:00"
    private LocalTime showTime;

    private List<String> requestedSeats;

    private Integer theaterId;

    private String mobileNo;
}
