package com.paultamayo.demo.mockito.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.paultamayo.demo.mockito.domains.Person;
import com.paultamayo.demo.mockito.repository.PersonRepository;

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

	public List<Person> findByNativeSQL() {
		return repository
				.findByNativeSQL().stream().map(t -> Person.builder().id(t.get("ID", Long.class))
						.name(t.get("NAME", String.class)).birthDate(t.get("BIRTHDAY", LocalDate.class)).build())
				.toList();
	}

	public Person save(Person person) {
		return repository.save(person);
	}
}
