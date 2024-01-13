package com.paultamayo.mockito;

import lombok.extern.flogger.Flogger;

@Flogger
public class Application {

    public String helloWorld(String name) {
        return String.format("Hello World %s!", name);

    }

    public static void main(String[] args) {
        Application app = new Application();

        log.atInfo().log(app.helloWorld("Diego"));
    }
}
