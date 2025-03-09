package com.paultamayo.patterndesign.creational._02;

public class ChickenRestaurant extends Restaurant {

    @Override
    Hamburger createHamburger() {
        return new ChickenHamburger();
    }

}
