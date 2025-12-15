package com.Book_My_Show.Requests;

import lombok.Data;

@Data
public class AddUserRequest {
    private String name;
    private Integer age;
    private String emailId;
    private String mobileNo;
}
