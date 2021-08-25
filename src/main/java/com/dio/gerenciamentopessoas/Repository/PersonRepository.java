package com.dio.gerenciamentopessoas.Repository;

import com.dio.gerenciamentopessoas.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
