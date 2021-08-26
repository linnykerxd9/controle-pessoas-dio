package com.dio.gerenciamentopessoas.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundExcetion extends Exception {
    
    public PersonNotFoundExcetion(Long id){
        super("Person not found with ID: "+ id);
    }
}
