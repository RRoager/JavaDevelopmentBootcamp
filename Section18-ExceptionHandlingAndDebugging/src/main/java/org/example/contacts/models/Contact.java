package org.example.contacts.models;

import java.text.ParseException;
import java.time.LocalDate;

public class Contact {
    private String name;
    private int age;
    private LocalDate birthDate;
    private String phoneNumber;

    public Contact(String name, String birthDate, String phoneNumber) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number can't be less than 5 characters");
        }

        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.age = LocalDate.now().getYear() - this.birthDate.getYear();
        this.phoneNumber = phoneNumber;
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.birthDate = source.birthDate;
        this.age = source.age;
        this.phoneNumber = source.phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;

    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = LocalDate.parse(birthDate);
        setAge(this.birthDate.getYear());
    }

    private void setAge(int birthYear) {
        this.age = LocalDate.now().getYear() - birthYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("phone number cannot be null/blank");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number can't be less than 5 characters");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Birth Date: " + birthDate + "\n" +
                "Age: " + age + " year old\n";
    }
}
