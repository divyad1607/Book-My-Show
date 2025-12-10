package com.Book_My_Show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "theaters")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Theater {

    @Id
    private Integer theaterId;

    private String name;

    private String address;

    private Integer onOfScreens;
}
