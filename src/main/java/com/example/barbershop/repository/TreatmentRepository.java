package com.example.barbershop.repository;


import com.example.barbershop.entity.Treatment;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TreatmentRepository {

    private final Set<Treatment> serviceBD =
            new HashSet<>(Set.of(
                    new Treatment(1L,"Taglio Adulto", 15.00f,30),
                    new Treatment(2L, "Taglio + Shampoo", 20.00f, 30)
            ));



// return all services
    public Optional<Set<Treatment>> getAllServices(){

        return Optional.of(serviceBD);
    }


// return service by Id
    public Optional<Treatment> getTreatmentById(Long id){

        Optional<Treatment> serviceReturn =  serviceBD.stream()
                .filter(service -> service.getId().equals(id))
                .findFirst();

        return serviceReturn;
    }

// Add service
    public Optional<Treatment> saveService(Treatment service){

        serviceBD.add(service);

        return Optional.of(service);

    }


// Remove service
    public boolean removeService(Long id){

        return serviceBD.removeIf(service -> service.getId().equals(id));
    }

}
