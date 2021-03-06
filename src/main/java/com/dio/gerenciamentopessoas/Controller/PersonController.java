package com.dio.gerenciamentopessoas.Controller;

import com.dio.gerenciamentopessoas.Dto.Request.PersonDTO;
import com.dio.gerenciamentopessoas.Entity.Person;
import com.dio.gerenciamentopessoas.Exception.PersonNotFoundExcetion;
import com.dio.gerenciamentopessoas.Service.PersonService;
import com.dio.gerenciamentopessoas.Dto.Response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {


    PersonService personService;

    @GetMapping
    public List<PersonDTO> allPersons(){
        return personService.allPersons();
    }

    @GetMapping("/{idPerson}")
    public PersonDTO personById(@PathVariable("idPerson") Long id) throws PersonNotFoundExcetion {
        return personService.personById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @PutMapping("/{idPerson}")
    public MessageResponseDTO updatePerson(@PathVariable("idPerson") Long id,@RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundExcetion {
        return personService.updatePerson(id , personDTO);
    }

    @DeleteMapping("/{idPerson}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable("idPerson") Long id) throws PersonNotFoundExcetion {
         personService.deletePerson(id);
    }

}
