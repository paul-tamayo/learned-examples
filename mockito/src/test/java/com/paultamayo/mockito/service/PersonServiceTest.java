package com.paultamayo.mockito.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.paultamayo.mockito.domains.Person;
import com.paultamayo.mockito.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    private static List<Person> people;

    @Mock
    private PersonRepository repository;

    @InjectMocks
    private PersonService service;

    @BeforeAll
    static void init() {
        people = new ArrayList<>();
        people.add(Person.builder().id(1L).name("Diego").birthDate(LocalDate.of(1986, Month.DECEMBER, 23)).build());
        people.add(Person.builder().id(2L).name("Juan").birthDate(LocalDate.of(1987, Month.JULY, 3)).build());
        people.add(Person.builder().id(3L).name("Manuel").birthDate(LocalDate.of(1988, Month.MARCH, 13)).build());
        people.add(Person.builder().id(4L).name("Pedro").birthDate(LocalDate.of(1989, Month.NOVEMBER, 16)).build());
        people.add(Person.builder().id(5L).name("Carlos").birthDate(LocalDate.of(1990, Month.MAY, 15)).build());
    }

    @BeforeEach
    void before() {
        service = new PersonService(repository);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(people);

        List<Person> persons = service.findAll();
        assertNotNull(persons);
        assertEquals(5, persons.size());
    }

}
