package com.dio.gerenciamentopessoas.Controller;

import com.dio.gerenciamentopessoas.Entity.Person;
import com.dio.gerenciamentopessoas.Service.PersonService;
import com.dio.gerenciamentopessoas.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public List<Person> allPersons(){
        return personService.allPersons();
    }

    @GetMapping("/{idPerson}")
    public Optional<Person> personById(@PathVariable("idPerson") Long id){
        return personService.personById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }

    @PutMapping
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    @DeleteMapping("/{idPerson}")
    public void deletePerson(@PathVariable("idPerson") Long id){
         personService.deletePerson(id);
    }

}
