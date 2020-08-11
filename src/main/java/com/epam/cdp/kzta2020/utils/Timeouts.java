package com.epam.cdp.kzta2020.utils;

public enum Timeouts {
    ZERO_WAITING(0),
    ORDINARY_WAITING(10);


    private int seconds;
    private int milliseconds;

    Timeouts(int seconds) {
        this.seconds = seconds;
        this.milliseconds =seconds*1000;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }
}
