package com.itcompany;

import java.util.Random;

public class LastNameEnding {
    // Fields
    static final String[] endOfLastName = { "yan", "ov", "ova" };

    // Methods
    public static String EndOfLastName() {
        var rand = new Random();
        int index = rand.nextInt(endOfLastName.length);
        String endingOfLastName = endOfLastName[index];
        return endingOfLastName;

    }
}
