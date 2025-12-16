package com.Book_My_Show.Requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String emailId;
    private String password;
}
