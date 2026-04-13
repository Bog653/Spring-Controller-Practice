package com.example.barbershop.mapper;

import com.example.barbershop.dto.BarberDtoMapper;
import com.example.barbershop.entity.Barber;
import org.mapstruct.Mapper;


/**
 * MapStruct is a mapper IO.
 *
 * You can define model and dto mapper, for example (Barber and BarberDtoMapper)
 * and define interface with all map you need.
 *
 * Match key-data is implicit if name is the same in model and Dto.
 * Remember dependencies like processor-mapStruct...
 */

/**
 * Another example is ModelMapper.
 * Is a class can map object source element in destination class.
 * Is define an example in BarberService class.
 */

@Mapper(componentModel = "spring")
public interface BarberMapper {

    /* In this example map Barber in BarberDto for return name and surname.
     */
    BarberDtoMapper mapperBarberById(Barber barber);



}
