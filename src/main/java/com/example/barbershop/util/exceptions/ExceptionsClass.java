package com.example.barbershop.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsClass {



@ExceptionHandler(value = MethodArgumentTypeMismatchException.class, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> errorPathvalidation(MethodArgumentTypeMismatchException exception){

    Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("error", "Formato parametro errato");
    body.put("message", String.format("Il valore '%s' non è un numero valido per l'ID", exception.getValue()));
    return ResponseEntity.badRequest().body(body);

}

@ExceptionHandler(value = NoSuchElementException.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity notFoundElement(NoSuchElementException exception){
    return ResponseEntity.notFound().build();


}


@ExceptionHandler(value = MethodArgumentNotValidException.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> keyNotPresent(MethodArgumentNotValidException ex){

        Map<String, Object> body = new LinkedHashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();


        body.put("timestamp", LocalDateTime.now());
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
}



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonMappingErrors(HttpMessageNotReadableException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Formato JSON non valido");

        // Messaggio semplificato per l'utente
        body.put("message", "Il corpo della richiesta contiene chiavi errate o manca di campi fondamentali");

        return ResponseEntity.badRequest().body(body);
    }
}
