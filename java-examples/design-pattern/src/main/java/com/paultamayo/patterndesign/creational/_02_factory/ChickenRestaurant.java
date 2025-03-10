package com.paultamayo.patterndesign.creational._02_factory;

public class ChickenRestaurant extends Restaurant {

    @Override
    Hamburger createHamburger() {
        return new ChickenHamburger();
    }

}
