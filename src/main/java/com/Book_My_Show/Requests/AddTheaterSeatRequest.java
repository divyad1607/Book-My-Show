package com.Book_My_Show.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterSeatRequest {

    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
}
