package com.Book_My_Show.Requests;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddShowRequest {

    private LocalTime showTime;
    private LocalDate showDate;
    private String movieName;
    private Integer theaterId;
}
