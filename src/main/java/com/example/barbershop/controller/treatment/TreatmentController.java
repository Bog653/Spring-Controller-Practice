package com.example.barbershop.controller.treatment;
import com.example.barbershop.dto.TreatmentDto;
import com.example.barbershop.entity.Treatment;
import com.example.barbershop.service.treatmentService.TreatmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/app/v1")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;



@GetMapping(path = "/treatment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> getAllServices(){
            Map<String,Object> body = new HashMap<>();
            Optional<Set<Treatment>> treatments = treatmentService.getAllServices();

            body.put("data", treatments.get());
            return ResponseEntity.ok().body(body);

}

@GetMapping(path = "/treatment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,Object>> getTreatmentById(@PathVariable @Valid Long id){
    Map<String,Object> body = new HashMap<>();
    Optional<Treatment> treatment = treatmentService.getTreatmentById(id);

    body.put("data", treatment.get());
    return ResponseEntity.ok().body(body);

}



 @PostMapping(path = "/treatment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
 @ResponseBody
 public Treatment saveTreatment(@Valid @RequestBody TreatmentDto treatmentDto){


    Optional<Treatment> treatment = treatmentService.saveService(treatmentDto);

     return treatment.get();

    }


}
