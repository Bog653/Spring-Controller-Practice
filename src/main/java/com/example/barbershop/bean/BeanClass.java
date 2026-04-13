package com.example.barbershop.bean;

import com.example.barbershop.repository.BarberRepository;
import com.example.barbershop.repository.TreatmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanClass {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();

    }

    @Bean(name = "barberRepoData")
    public BarberRepository barberRepository(){
        return new BarberRepository();

    }

    @Bean(name = "treatmentRepoData")
    public TreatmentRepository treatmentRepository(){
        return new TreatmentRepository();
    }

}
