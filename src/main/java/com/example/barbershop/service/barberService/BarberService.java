package com.example.barbershop.service.barberService;

import com.example.barbershop.dto.BarberDto;
import com.example.barbershop.dto.BarberDtoMapper;
import com.example.barbershop.entity.Barber;
import com.example.barbershop.mapper.BarberMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.barbershop.repository.BarberRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarberService implements BarberInterface{

    @Autowired
    @Qualifier("barberRepoData")
    private BarberRepository barberRepository;

    @Autowired
    private ModelMapper modelMapper;

    // altri tipo di mapper
    @Autowired
    private BarberMapper barberMapper;


// service return all barbers
    @Override
    public List<BarberDto> getAllBarbers(){
        List<Barber> barberList = barberRepository.getAllBarbers();

        // ModelMap map(object source, Destination<T> class)
        return barberList.stream()
                .map(barber -> modelMapper.map(barber, BarberDto.class))
                .collect(Collectors.toList());
    }

// service return barber by id
@Override
    public BarberDtoMapper getBarberById(Long id){
        Optional<Barber> barber = barberRepository.getBarberById(id);
        return barber.map( barberMapper::mapperBarberById)
                .orElseThrow();

    }

// service add Barber
@Override
    public Optional<Barber> saveBarber(BarberDto barberDto){
        List<Barber> barberList = barberRepository.getAllBarbers();
        int i = barberList.size();
        Long l = (long)++i;

        Barber barber = Barber.builder()
                .age(barberDto.getAge())
                .id(l)
                .name(barberDto.getName())
                .surname(barberDto.getSurname())
                .isActive(true)
                .build();

        return barberRepository.saveBarber(barber);

    }


// Remove Barber
@Override
    public boolean removeBarber(Long id){
        return barberRepository.removeBarberById(id);
    }

}
