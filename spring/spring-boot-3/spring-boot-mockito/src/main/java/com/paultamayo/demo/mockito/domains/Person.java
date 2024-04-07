package com.paultamayo.demo.mockito.domains;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Person {

    private Long id;

    private String name;

    private LocalDate birthDate;
}
