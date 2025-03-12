package com.paultamayo.patterndesign.creational._04_singleton;

import java.util.Objects;

import lombok.Getter;
import lombok.extern.flogger.Flogger;

@Flogger
public class DatabaseConnection {

    private static DatabaseConnection instance;

    public static DatabaseConnection getInstance() {
        if (Objects.isNull(instance)) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    @Getter
    private boolean connected;

    private DatabaseConnection() {
        connected = false;
    }

    public void connect() {
        if (connected) {
            log.atInfo().log("Database connection is already connected");
        } else {
            connected = true;
            log.atInfo().log("Connecting to database");
        }
    }

    public void disconnect() {
        if (!connected) {
            log.atInfo().log("Database connection is disconnected");
        } else {
            connected = false;
            log.atInfo().log("Disconnected from database");
        }
    }
}
