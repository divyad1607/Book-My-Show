package com.Book_My_Show.Requests;

import com.Book_My_Show.Enums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Double duration;
    private LocalDate releaseDate;
    private Language language;
    private Double rating;

}
