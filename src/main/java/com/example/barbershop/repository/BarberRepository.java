package com.example.barbershop.repository;

import com.example.barbershop.entity.Barber;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BarberRepository {

   // Example data for test

    private final List<Barber> barberBd =
            new ArrayList<>(List.of(
                    new Barber(1L,"Mario","Rossi",20,true),
                    new Barber(2L,"Chiara","Bruni",19,true),
                    new Barber(3L,"Marta","Bianchi",30,true)
            ));


// Return all barbers
public List<Barber> getAllBarbers(){

    return barberBd;

}

// Return barber by Id
public Optional<Barber> getBarberById(Long id){

    Optional<Barber> barber = barberBd.stream()
            .filter(barbers -> barbers.getId().equals(id))
            .findFirst();

    return barber;

}

// Add barber

public Optional<Barber> saveBarber(Barber barber){
    barberBd.add(barber);
    return Optional.of(barber);
}


// Remove barber
public boolean removeBarberById(Long id){

    return barberBd.removeIf(barber -> barber.getId().equals(id));

}

}


