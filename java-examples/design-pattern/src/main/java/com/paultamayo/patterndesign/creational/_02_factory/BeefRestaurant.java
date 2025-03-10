package com.paultamayo.patterndesign.creational._02_factory;

public class BeefRestaurant extends Restaurant {

    @Override
    Hamburger createHamburger() {
        return new BeefHamburger();
    }

}
