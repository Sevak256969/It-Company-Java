package com.itcompany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

public class CompanyUtil {
    static HashSet<String> phoneNumberSet = new HashSet<>();
    static HashSet<String> emailNameSet = new HashSet<>();

    // Minimum valid applicant age
    static byte APPLICANT_MIN_AGE = 18;
    // Maximum valid applicant age
    static byte APPLICANT_MAX_AGE = 70;

    static final String[] syllables = { "ab", "sa", "de", "po", "rub", "ask",
            "mam", "ket", "zar", "lu", "te", "col", "sar", "vol", "ver" };

    static final String[] firstNames = { "Sevak", "Nina", "Grisha", "Karine",
            "Arevshat", "Margarita", "Karen", "Smbat", "Rouben", "Garegin",
            "Narine", "Nane", "Marina", "Suren", "Arkadij" };

    /// <summary>Generates random date of birth values within the specified age range.</summary>
    /// <param name="minAge">The minimum age.</param>
    /// <param name="maxAge">The maximum age.</param>
    /// <returns>The DateTime value within specified range.</returns>
    public static LocalDate getDateOfBirth(int minAge, int maxAge) {
        // input's validation: check age limits, make sure their within
        // the allowed range

        minAge = Math.max(APPLICANT_MIN_AGE, minAge);
        maxAge = Math.min(APPLICANT_MAX_AGE, maxAge);

        var rand = new Random();
        LocalDate currentDateTime = LocalDate.now();

        int applicantAge = rand.nextInt(maxAge - minAge + 1 ) + minAge;
        int year = currentDateTime.getYear() - applicantAge;
        int day;
        int month = rand.nextInt(12) + 1;
        if (month == 2) {
            day = rand.nextInt( 28) + 1;
        }
        else {
            day = rand.nextInt( 29) + 1;
        }
        LocalDate applicantDateOfBirth =  LocalDate.of(year, month,  day);
        System.out.println("Generated birthDate is  "+ applicantDateOfBirth.toString());
        return applicantDateOfBirth;
    }

    public static String getLastName() {
        var rand = new Random();
        int index = rand.nextInt(syllables.length);
        String lastName = syllables[index].substring(0, 1).toUpperCase();
        index = rand.nextInt(syllables.length);
        lastName += syllables[index];
        lastName += "yan";
        System.out.println(lastName);
        return lastName;
    }

    public static String getFirstName() {
        var rand = new Random();
        int index = rand.nextInt(firstNames.length);
        String firstName = firstNames[index];
        System.out.println(firstName);
        return firstName;
    }

    public static Employee.QualificationLevel getQualificationLevel() {
        Random rand = new Random();
        int qualificationLevelCount = Employee.QualificationLevel.values().length;
        int randomIndex = rand.nextInt(qualificationLevelCount);
        return Employee.QualificationLevel.values()[randomIndex];
    }

    public static Employee.SpecialistType getSpecialistType() {
        Random rand = new Random();
        int specialistTypeCount = Employee.SpecialistType.values().length;
        int randomIndex = rand.nextInt(specialistTypeCount);
        return Employee.SpecialistType.values()[randomIndex];
    }

    public static String getRandomStringOfSymbols(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        var rand = new Random();
        char ch;
        for (int i = 0; i < size; i++) {
            ch = (char) Math.floor(74 * rand.nextDouble() + 48);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
    public static int getRandomNumber(int minValue, int maxValue) {
        var rand = new Random();
        return rand.nextInt( maxValue) + minValue;
    }

    public static String generateRandomString(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        char ch;

        for (int i = 0; i < size; i++) {
            ch = (char) Math.floor(26 * random.nextDouble() + 97);
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static String generateRandomUpperCase(int size ) {
        StringBuilder upperCase = new StringBuilder();
        Random random = new Random();
        char ch;

        for (int i = 0; i < size; i++) {
            ch = (char) Math.floor(26 * random.nextDouble() + 65);
            upperCase.append(ch);
        } return upperCase.toString();
    }


    public static String getRandomEmail(int size ) {

        int attemptCount = 0;
        String randomEmail;
        do {
            randomEmail = getRandomStringOfSymbols(size) + NameDomain.endOfEmail();
            attemptCount++;
            if (attemptCount > 100) {
                randomEmail = "";
                break;
            }
        } while (emailNameSet.contains(randomEmail));

        emailNameSet.add(randomEmail);
        return randomEmail;
    }

    public static int generateRandomNumber(int minValue, int maxValue) {
        var random = new Random();
        return random.nextInt(maxValue) + minValue;
    }

    public static String getRandomPhoneNumber() {
        int attemptCount = 0;
        var random = new Random();
        int[] array = new int[PhoneNumberLength.phoneLength()];
        String phoneNumber = "";

        for (int i = 0; i < array.length; i++){
            array[i] = generateRandomNumber(0, 9);
            phoneNumber += array[i];
        }
        do {
            phoneNumber = CountryCode.oneCountryCode() + OperatorCode.operator() + phoneNumber;
            attemptCount++;
            if (attemptCount > 100) {
                phoneNumber = "";
                break;
            }
        } while (phoneNumberSet.contains(phoneNumber));

        phoneNumberSet.add(phoneNumber);
        return phoneNumber;
    }

    public static String getUuid() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
