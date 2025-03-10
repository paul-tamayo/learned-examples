package com.paultamayo.patterndesign.creational._02_factory;

public class ChickenHamburger implements Hamburger {

    @Override
    public void prepare() {
        System.out.println("Preparando una hamburguesa de pollo");
    }

}
