package com.example.barbershop.service.barberService;

import com.example.barbershop.dto.BarberDto;
import com.example.barbershop.dto.BarberDtoMapper;
import com.example.barbershop.entity.Barber;

import java.util.List;
import java.util.Optional;

public interface BarberInterface {

    public List<BarberDto> getAllBarbers();

    public BarberDtoMapper getBarberById(Long id);

    public Optional<Barber> saveBarber(BarberDto barberDto);

    public boolean removeBarber(Long id);

}
