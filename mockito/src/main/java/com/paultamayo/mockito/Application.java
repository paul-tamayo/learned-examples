package com.paultamayo.mockito;

import lombok.extern.flogger.Flogger;

@Flogger
public class Application {

    public static void main(String[] args) {
        log.atInfo().log("Hello World!");
    }
}
