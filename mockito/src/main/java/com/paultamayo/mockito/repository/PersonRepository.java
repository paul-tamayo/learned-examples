package com.paultamayo.mockito.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.paultamayo.mockito.domains.Person;

import jakarta.persistence.Tuple;

public interface PersonRepository {

	long count();

	void delete(Person person);

	List<Person> findAll();

	Optional<Person> findById(long id);

	@Query(value = "SELECT * FROM PERSONA")
	List<Tuple> findByNativeSQL();

	Person save(Person person);
}
