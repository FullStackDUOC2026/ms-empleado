package com.example.ms_empleado.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRunTimeexception(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND) .body(ex.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlerValidException(MethodArgumentNotValidException mt){
        String mensaje = mt.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " +
                        error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
    }




}
