package com.project.HotelBooking_BackEnd.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collation = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    private String userId;
    private String username;
    private String email;
    private String password;
    private String role="USER";
}
