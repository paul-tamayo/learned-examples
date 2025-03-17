package com.paultamayo.patterndesign.structural._01_adapter;

import lombok.extern.flogger.Flogger;

@Flogger
public class LoggerAdapter {

    public void info(String message) {
        log.atInfo().log(message);
    }

    public void error(String message) {
        log.atSevere().log(message);
    }

    public void warn(String message) {
        log.atWarning().log(message);
    }
}
