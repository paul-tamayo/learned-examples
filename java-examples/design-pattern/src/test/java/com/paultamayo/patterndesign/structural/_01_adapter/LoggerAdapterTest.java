package com.paultamayo.patterndesign.structural._01_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class LoggerAdapterTest {

    private LoggerAdapter loggerAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        loggerAdapter = new LoggerAdapter();
    }

    @Test
    public void testInfo() {
        String message = "Info message";
        loggerAdapter.info(message);
    }

    @Test
    public void testError() {
        String message = "Error message";
        loggerAdapter.error(message);
    }

    @Test
    public void testWarn() {
        String message = "Warn message";
        loggerAdapter.warn(message);
    }
}