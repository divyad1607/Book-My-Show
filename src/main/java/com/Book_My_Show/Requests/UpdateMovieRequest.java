package com.Book_My_Show.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMovieRequest {
    private Integer movieName;
    private double rating;
    private double duration;
}
