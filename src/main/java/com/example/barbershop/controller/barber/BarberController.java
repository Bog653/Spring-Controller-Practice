package com.example.barbershop.controller.barber;

import com.example.barbershop.dto.BarberDto;
import com.example.barbershop.dto.BarberDtoMapper;
import com.example.barbershop.entity.Barber;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.barbershop.service.barberService.BarberService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/app/v1")
public class BarberController {

    @Autowired
    private BarberService barberService;


// GET all barbers
@GetMapping(path = "/barber", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Map<String,Object>> getAllBarbers(){
    Map<String,Object> body = new HashMap<>();

    List<BarberDto> barberList = barberService.getAllBarbers();

    body.put("data", barberList);

    return ResponseEntity.ok().body(body);

}


// GET barber by id

@GetMapping(path = "/barber/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public ResponseEntity<Map<String,Object>>  getBarberById(@PathVariable @Min(value = 1, message = "Valore deve essere intero positivo") Long id){

    BarberDtoMapper barberDto = barberService.getBarberById(id);
    Map<String,Object> body = new HashMap<>();

    body.put("data", barberDto);

    return ResponseEntity.ok().body(body);
}


// POST barber
@PostMapping(path = "/barber", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public HttpEntity<Barber> insertBarber(@Valid @RequestBody BarberDto barberDto){

    Optional<Barber> barberReturn = barberService.saveBarber(barberDto);

   return new HttpEntity<>(barberReturn.get());
}


// DELETE barber
@DeleteMapping(path = "/barber/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Void> removeBarber(@PathVariable @Min(1) Long id){

    boolean value = barberService.removeBarber(id);
    if (value) return ResponseEntity.ok().build();
    else return ResponseEntity.notFound().build();
}

}
