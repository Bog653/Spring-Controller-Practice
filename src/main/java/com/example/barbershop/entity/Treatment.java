package com.example.barbershop.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treatment {

    private Long id;

    private String name;

    private float price;

    private int duration;

}
