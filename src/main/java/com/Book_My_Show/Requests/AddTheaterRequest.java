package com.Book_My_Show.Requests;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterRequest {

    private String name;

    private String address;

    private Integer noOfScreens;


}
