package com.Book_My_Show.Requests;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class AddShowSeatRequest {

    private Integer showId;
    private Integer priceOfClassicSeats;
    private Integer priceOfPremiumSeats;
}
