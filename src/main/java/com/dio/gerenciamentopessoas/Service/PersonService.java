package com.dio.gerenciamentopessoas.Service;

import com.dio.gerenciamentopessoas.Entity.Person;
import com.dio.gerenciamentopessoas.Repository.PersonRepository;
import com.dio.gerenciamentopessoas.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){

         Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + savedPerson.getId())
                .build();
    }

    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }

    public List<Person> allPersons(){
        return personRepository.findAll();
    }

    public Optional<Person> personById(Long id){
        return personRepository.findById(id);
    }
}
