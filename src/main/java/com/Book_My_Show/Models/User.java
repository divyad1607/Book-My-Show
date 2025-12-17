package com.Book_My_Show.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;

    @Column(unique = true)
    private String emailId;

    @Column(unique = true)
    private String mobNo;


}