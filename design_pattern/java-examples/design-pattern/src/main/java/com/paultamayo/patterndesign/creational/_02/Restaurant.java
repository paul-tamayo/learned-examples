package com.paultamayo.patterndesign.creational._02;

public abstract class Restaurant {

    abstract Hamburger createHamburger();

    public Hamburger orderHamburger() {
        Hamburger hamburger = createHamburger();
        hamburger.prepare();
        
        return hamburger;
    }
}
