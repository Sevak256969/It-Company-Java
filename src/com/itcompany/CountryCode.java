package com.itcompany;

import java.util.Random;

public class CountryCode {
    // Fields
    static final String [] countriesCodes = { "+374", "+7", "+46" };

    // Methods
    public static String oneCountryCode() {
        var rand = new Random();
        int index = rand.nextInt(countriesCodes.length);
        String countryCode = countriesCodes[index];
        return countryCode;
    }
}

