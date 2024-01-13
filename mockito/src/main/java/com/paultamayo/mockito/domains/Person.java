package com.paultamayo.mockito.domains;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {

    private Long id;

    private String name;

    private LocalDate birthDate;
}
