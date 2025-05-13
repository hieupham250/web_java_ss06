package com.example.ss06.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private int id;
    private String name;
    private LocalDate birthday;
    private String phone;
    private String email;
    private double salary;
    private String position;
}
