package com.Book_My_Show.Requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String emailId;
    private String mobileNo;
    private String password;
}
