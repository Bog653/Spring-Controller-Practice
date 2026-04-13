package com.example.barbershop.entity;


import lombok.*;

// @Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Barber{

    private Long id;

    private String name;

    private String surname;

    private int age;

    private boolean isActive;


}
