package com.paultamayo.patterndesign.creational._03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DocumentTest {

    private Document document;

    private AuthorInformation info;

    @BeforeEach
    void setUp() {
        info = new AuthorInformation("Diego Tamayo", LocalDate.now());
        document = new Document(info, "Patrones de diseño en Java", "Patrones de Diseño");
    }

    @Test
    void testClone() {
        Document cloneDocument = document.clone();

        cloneDocument.getInfo().setAuthor("Paul Tamayo");
        cloneDocument.getInfo().setBirthDay(LocalDate.of(1990, 10, 10));

        assertEquals("Paul Tamayo", cloneDocument.getInfo().getAuthor());

        //TODO: Clona las clases anidadas como se puede observar con la prueba
        assertFalse(info == cloneDocument.getInfo());
    }

    @Test
    void testCloneWithBeanUtils() throws Exception {
        Document cloneDocument = document.cloneWithBeanUtils();

        assertEquals("Diego Tamayo", cloneDocument.getInfo().getAuthor());

        //TODO: No clona las clases anidadas como se puede observar con la prueba
        assertTrue(info == cloneDocument.getInfo());
    }
}
