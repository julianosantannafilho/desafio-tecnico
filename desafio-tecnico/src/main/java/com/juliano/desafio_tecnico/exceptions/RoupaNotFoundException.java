package com.juliano.desafio_tecnico.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoupaNotFoundException extends EntityNotFoundException {
    
    public RoupaNotFoundException(String message) {
        super(message);
    }
}
