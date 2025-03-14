package com.paultamayo.patterndesign.creational._04_singleton;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataBaseConnectionTest {

    private DatabaseConnection dataBaseConnection1;

    private DatabaseConnection dataBaseConnection2;

    @BeforeEach
    void setUp() {
        dataBaseConnection1 = DatabaseConnection.getInstance();
        dataBaseConnection2 = DatabaseConnection.getInstance();
    }

    @Test
    void testGetInstance() {
        assertTrue(dataBaseConnection1 == dataBaseConnection2);
    }

    @Test
    void testDisconnect() {
        dataBaseConnection1.disconnect();

        assertFalse(dataBaseConnection2.isConnected());
    }

    @Test
    void testConnect() {
        dataBaseConnection2.connect();

        assertTrue(dataBaseConnection1.isConnected());
    }
}
