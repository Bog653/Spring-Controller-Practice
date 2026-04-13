package com.example.barbershop.service.treatmentService;

import com.example.barbershop.dto.TreatmentDto;
import com.example.barbershop.entity.Treatment;

import java.util.Optional;
import java.util.Set;

public interface TreatmentInterface {

    public Optional<Set<Treatment>> getAllServices();

    public Optional<Treatment> getTreatmentById(Long id);
    public Optional<Treatment> saveService(TreatmentDto treatment);

    public boolean removeService(Long id);
}
