package com.paultamayo.mockito.service;

import java.util.List;
import java.util.Optional;

import com.paultamayo.mockito.domains.Person;
import com.paultamayo.mockito.repository.PersonRepository;

public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public Optional<Person> findById(long id) {
        return repository.findById(id);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public void delete(Person person) {
        repository.delete(person);
    }
}
