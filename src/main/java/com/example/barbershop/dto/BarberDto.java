package com.example.barbershop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BarberDto {

    @NotBlank(message = "Key name is not present")
    private String name;

    @NotBlank(message = "Key surname is not present")
    private String surname;

    @NotNull(message = "Key age is not present")
    @Positive(message = "Key age must be positive")
    private int age;

}
