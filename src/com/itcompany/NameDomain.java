package com.itcompany;

import java.util.Random;

public class NameDomain {
    // Fields
    static final String[] endOfEmails = { "@gmail.com", "@mail.ru", "@yahoo.com" };

    // Methods
    public static String endOfEmail() {
        var rand = new Random();
        int index = rand.nextInt(endOfEmails.length);
        String endOfEmail = endOfEmails[index];
        return endOfEmail;
    }
}
