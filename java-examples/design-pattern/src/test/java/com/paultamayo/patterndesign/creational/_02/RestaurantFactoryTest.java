package com.paultamayo.patterndesign.creational._02;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestaurantFactoryTest {

    private RestaurantFactory factory;

    @BeforeEach
    void init() {
        factory = new RestaurantFactory();
    }

    @Test
    void testGetRestaurantForChicken() {
        Restaurant restaurant = factory.getRestaurant("chicken");
        Hamburger hamburger = restaurant.orderHamburger();

        assertInstanceOf(ChickenRestaurant.class, restaurant);
        assertInstanceOf(ChickenHamburger.class, hamburger);
    }

    @Test
    void testGetRestaurantForBeef() {
        Restaurant restaurant = factory.getRestaurant("beef");
        Hamburger hamburger = restaurant.orderHamburger();

        assertInstanceOf(BeefRestaurant.class, restaurant);
        assertInstanceOf(BeefHamburger.class, hamburger);
    }

    @Test
    void testGetRestaurantWithError() {
        Exception exception = assertThrows(RuntimeException.class, () -> factory.getRestaurant("any"));

        assertInstanceOf(IllegalArgumentException.class, exception);
    }
}
