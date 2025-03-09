package com.paultamayo.patterndesign.creational._02;

public class BeefHamburger implements Hamburger {

    @Override
    public void prepare() {
        System.out.println("Preparando una hamburguesa de res");
    }

}
