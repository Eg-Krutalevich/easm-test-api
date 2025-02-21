package ru.easm.api.utils;

import java.util.UUID;

public class RandomUtils {

    private static final String numeric = "01234569";
    private static final String lowerSymbols = "abcdefghijklmnopqrstuvwxyz";
    private static final String upperSymbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateUUIDasString() {
        return UUID.randomUUID().toString();
    }

    public static String generateNumericAsString(Integer length) {
        return String.valueOf(Long.valueOf(generateStringType(length, numeric)));
    }

    public static String generateNumeric(Integer length) {
        return generateStringType(length, numeric);
    }

    public static String generateLowerCaseString(Integer length) {
        return generateStringType(length, lowerSymbols);
    }

    public static String generateUpperCaseString(Integer length) {
        return generateStringType(length, upperSymbols);
    }

    private static String generateStringType(Integer length, String string) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int) (string.length() * Math.random());
            sb.append(string.charAt(index));
        }
        return sb.toString();
    }
}