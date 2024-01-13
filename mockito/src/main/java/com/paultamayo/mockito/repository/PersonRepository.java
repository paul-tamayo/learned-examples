package com.paultamayo.mockito.repository;

import java.util.List;
import java.util.Optional;

import com.paultamayo.mockito.domains.Person;

public interface PersonRepository {

    Person save(Person person);

    Optional<Person> findById(long id);

    List<Person> findAll();

    long count();

    void delete(Person person);
}
