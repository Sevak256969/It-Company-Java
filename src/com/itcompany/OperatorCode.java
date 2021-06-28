package com.itcompany;

import java.util.Random;

public class OperatorCode {
    // Fields
    static final String[] operatorCodes = { "93", "94", "91", "96", "99", "77", "43", "44", "55" };

    // Methods
    public static String operator() {
        var rand = new Random();
        int index = rand.nextInt(operatorCodes.length);
        String operatorCode = operatorCodes[index];
        return operatorCode;
    }
}
