package com.orangehrm.demo.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

    private static final Faker faker = new Faker();

    public static String genetateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateMiddleName() {
        return faker.name().firstName();
    }

    public static String generateEmployeeID() {
        return String.valueOf(faker.number().numberBetween(1000, 9999));
    }


}
