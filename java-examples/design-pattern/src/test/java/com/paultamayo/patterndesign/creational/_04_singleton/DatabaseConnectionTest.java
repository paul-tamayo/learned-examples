package com.paultamayo.patterndesign.creational._04_singleton;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {

    @BeforeEach
    public void setUp() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        if (instance.isConnected()) {
            instance.disconnect();
        }
    }

    @Test
    public void testSingletonInstance() {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        assertSame(instance1, instance2, "Instances should be the same");
    }

    @Test
    public void testInitialConnectionState() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        assertFalse(instance.isConnected(), "Initial connection state should be false");
    }

    @Test
    public void testConnect() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        instance.connect();
        assertTrue(instance.isConnected(), "Connection state should be true after connect");
    }

    @Test
    public void testDisconnect() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        instance.connect();
        instance.disconnect();
        assertFalse(instance.isConnected(), "Connection state should be false after disconnect");
    }

    @Test
    public void testDoubleConnect() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        instance.connect();
        instance.connect();
        assertTrue(instance.isConnected(), "Connection state should remain true after double connect");
    }

    @Test
    public void testDoubleDisconnect() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        instance.disconnect();
        instance.disconnect();
        assertFalse(instance.isConnected(), "Connection state should remain false after double disconnect");
    }
}