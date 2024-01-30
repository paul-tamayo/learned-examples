package com.paultamayo.mockito.service;

import java.util.List;
import java.util.Optional;

import com.paultamayo.mockito.domains.Person;
import com.paultamayo.mockito.repository.PersonRepository;

import jakarta.persistence.Tuple;

public class PersonService {

	private final PersonRepository repository;

	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public long count() {
		return repository.count();
	}

	public void delete(Person person) {
		repository.delete(person);
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Optional<Person> findById(long id) {
		return repository.findById(id);
	}

	public List<Tuple> findByNativeSQL() {
		return repository.findByNativeSQL();
	}

	public Person save(Person person) {
		return repository.save(person);
	}
}
