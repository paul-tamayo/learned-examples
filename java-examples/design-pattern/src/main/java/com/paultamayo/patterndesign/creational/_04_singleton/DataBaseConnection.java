package com.paultamayo.patterndesign.creational._04_singleton;

import java.util.Objects;

import lombok.Getter;
import lombok.extern.flogger.Flogger;

@Flogger
public class DataBaseConnection {

    private static DataBaseConnection instance;

    @Getter
    private boolean connected;

    private DataBaseConnection() {
        connected = false;
    }

    public static DataBaseConnection getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public void connect() {
        connected = true;

        log.atInfo().log("Connected to database");
    }

    public void disconnect() {
        connected = false;

        log.atInfo().log("Disconnected from database");
    }
}
