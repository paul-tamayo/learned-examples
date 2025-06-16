package com.paultamayo.countries;

import com.intuit.karate.junit5.Karate;

class CountriesRunner {

    @Karate.Test
    Karate testCountries() {
        return Karate.run("countries").relativeTo(getClass());
    }

}
