package com.paultamayo.patterndesign.creational._02;

public class BeefRestaurant extends Restaurant {

    @Override
    Hamburger createHamburger() {
        return new BeefHamburger();
    }

}
