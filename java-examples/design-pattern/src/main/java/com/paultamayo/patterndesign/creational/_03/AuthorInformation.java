package com.paultamayo.patterndesign.creational._03;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthorInformation {

    private String author;

    private LocalDate birthDay;

    public AuthorInformation clone() {
        return new AuthorInformation(author, birthDay);
    }
}
