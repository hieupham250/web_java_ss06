package com.example.ss06.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
}
