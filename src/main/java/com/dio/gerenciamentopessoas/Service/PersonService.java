package com.dio.gerenciamentopessoas.Service;

import com.dio.gerenciamentopessoas.Dto.Request.PersonDTO;
import com.dio.gerenciamentopessoas.Entity.Person;
import com.dio.gerenciamentopessoas.Exception.PersonNotFoundExcetion;
import com.dio.gerenciamentopessoas.Mapper.PersonMapper;
import com.dio.gerenciamentopessoas.Repository.PersonRepository;
import com.dio.gerenciamentopessoas.Dto.Response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;


     private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave =  personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }

    public MessageResponseDTO updatePerson(PersonDTO personDTO){
        Person personToSave =  personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Update person with ID: " + savedPerson.getId())
                .build();
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public List<PersonDTO> allPersons(){

        List<Person>  allPeople = personRepository.findAll();

        List<PersonDTO> personListDTO = allPeople.stream()
                                        .map(personMapper::toDTO)
                                        .collect(Collectors.toList());
        return personListDTO;
    }

    public PersonDTO personById(Long id) throws PersonNotFoundExcetion {

        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundExcetion(id));

         return personMapper.toDTO(person);
    }
}
