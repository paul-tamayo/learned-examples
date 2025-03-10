package com.paultamayo.patterndesign.creational._02_factory;

public class RestaurantFactory {

    public Restaurant getRestaurant(String type) {
        switch (type) {
            case "chicken":
                return new ChickenRestaurant();
            case "beef":
                return new BeefRestaurant();
            default:
                throw new IllegalArgumentException(String.format("Restaurante %s inválido.", type));
        }
    }
}
