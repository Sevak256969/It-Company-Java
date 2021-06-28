package com.itcompany;

import java.time.LocalDate;

public class Person {

    // Fields
    String  personalId;
    LocalDate birthDate;
    LocalDate deceasedDate;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;

    // Constructor
    public Person( String personalId, String firstName, String lastName,
                   String phoneNumber, String email,  LocalDate birthDate) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate = birthDate;
    }

    // Properties
    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeceasedDate() {
        return deceasedDate;
    }

    public void setDeceasedDate(LocalDate deceasedDate) {
        this.deceasedDate = deceasedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Methods
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append(String.format("first name %1s ,last name = %2s, " +
                        "  birthdate = %3s, " + " personal id = %4s, deceasedDate = %5s ",
                this.firstName, this.lastName, this.birthDate, this.personalId, this.deceasedDate));

        return stringBuilder.toString();
    }
}
