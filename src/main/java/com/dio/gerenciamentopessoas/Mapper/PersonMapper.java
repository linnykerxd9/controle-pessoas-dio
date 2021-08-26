package com.dio.gerenciamentopessoas.Mapper;

import com.dio.gerenciamentopessoas.Dto.Request.PersonDTO;
import com.dio.gerenciamentopessoas.Entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
