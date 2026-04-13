package com.example.barbershop.dto;

import jakarta.validation.constraints.Min;
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

public class TreatmentDto {

    @NotBlank(message = "Key name is not present")
    private String name;

    @NotNull(message = "Key duration is not present")
    @Positive(message = "Key duration must be positive")
    private int duration;

    @NotNull(message = "Key price is not present")
    @Min(value = 1, message = "Key price must be positive")
    private float price;


}
