package ru.intodayer.servlets.utility;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SecretNumber {
    public static final int NUMBER_LENGTH = 4;
    private String number;

    public SecretNumber() {
        this.number = createSecretNumber();
    }

    public String getNumber() {
        return number;
    }

    private static boolean checkNumberContainsUniqueDigits(String userNumber) {
        Pattern p = Pattern.compile("^(?:([0-9])(?!.*\\1))*$");
        Matcher m = p.matcher(userNumber);
        return m.matches();
    }

    private static boolean numberNotHaveLeadingZeros(String userNumber) {
        Pattern p = Pattern.compile("^[1-9][0-9][0-9][0-9]");
        Matcher m = p.matcher(userNumber);
        return m.matches();
    }

    public static void validateNumber(String userNumber) {
        if (userNumber.length() != SecretNumber.NUMBER_LENGTH) {
            throw new IllegalArgumentException(
                "The number must has length of 4."
            );
        }
        if (!numberNotHaveLeadingZeros(userNumber)) {
            throw new IllegalArgumentException(
                "The number can not have leading zeros. " +
                "Example: 4567 - is correct; 0123 - not correct."
            );
        }
        if (!checkNumberContainsUniqueDigits(userNumber)) {
            throw new IllegalArgumentException(
                "The number must contain only unique digits. " +
                "Example: 1023 - is correct; 1022 - not correct."
            );
        }
    }

    private static String createSecretNumber() {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < SecretNumber.NUMBER_LENGTH) {
            uniqueNumbers.add(random.nextInt((9 - 1) + 1) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer x: uniqueNumbers) {
            sb.append(String.valueOf(x));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getNumber();
    }
}
