package com.example.barbershop.service.treatmentService;

import com.example.barbershop.dto.TreatmentDto;
import com.example.barbershop.entity.Treatment;
import com.example.barbershop.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TreatmentService implements TreatmentInterface{

//    private final TreatmentRepository treatmentRepository = new TreatmentRepository();

    @Autowired
    @Qualifier("treatmentRepoData")
    private TreatmentRepository treatmentRepository;

// return all services
    @Override
    public Optional<Set<Treatment>> getAllServices(){
       Optional<Set<Treatment>> treatments = treatmentRepository.getAllServices();

       return Optional.of(treatments)
               .orElseThrow();
    }


// return service by id
    @Override
    public Optional<Treatment> getTreatmentById(Long id){
        Optional<Treatment> treatment = treatmentRepository.getTreatmentById(id);

        return Optional.of(treatment)
                .orElseThrow();
    }

// Add service
    @Override
    public Optional<Treatment> saveService(TreatmentDto treatment){
        Optional<Set<Treatment>> treatments = Optional.of(treatmentRepository.getAllServices()
                .orElse(new HashSet<>()));

        int i = treatments.get().size();
        Long valueId = (long) ++i;

        Treatment insertTreatment = Treatment.builder()
                .name(treatment.getName())
                .duration(treatment.getDuration())
                .price(treatment.getPrice())
                .id(valueId)
                .build();

      boolean value = treatments.get().stream()
                .anyMatch(treatmentBd -> treatmentBd.getName().equals(insertTreatment.getName()));

        if (value) {
            return Optional.empty();
        }else{
            return treatmentRepository.saveService(insertTreatment);
        }

    }

// Remove service
    @Override
    public boolean removeService(Long id){

        return treatmentRepository.removeService(id);
    }






}
