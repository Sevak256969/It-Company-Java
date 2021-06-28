package com.itcompany;

import java.util.Random;

public class PhoneNumberLength {
    // Fields
    static final int[] phoneNumberLengthArray = { 6, 8, 10, 11 };

    // Methods
    public static int phoneLength() {
        var rand = new Random();
        int index = rand.nextInt(phoneNumberLengthArray.length);
        int phoneLength = phoneNumberLengthArray[index];
        return phoneLength;
    }
}
