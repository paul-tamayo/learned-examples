package com.paultamayo.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @InjectMocks
    private Application app;

    @Test
    void testHelloWorld() {
        String response = app.helloWorld("Diego");

        assertEquals("Hello World Diego!", response);
    }
}
