package ru.intodayer.servlets.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BullsAndCowsGame {
    private SecretNumber secretNumber;

    public BullsAndCowsGame() {
        this.secretNumber = new SecretNumber();
    }

    public String getSecretNumber() {
        return secretNumber.getNumber();
    }

    public List<Integer> handleUserAttempt(String userNumber) {
        SecretNumber.validateNumber(userNumber);

        List<Character> bulls = new ArrayList<>();
        List<Character> cows = new ArrayList<>();

        for (int i = 0; i < SecretNumber.NUMBER_LENGTH; i++) {
            if (this.secretNumber.getNumber().charAt(i) == userNumber.charAt(i)) {
                bulls.add(userNumber.charAt(i));
            }
            if (this.secretNumber.getNumber().contains(String.valueOf(userNumber.charAt(i)))
                && !bulls.contains(userNumber.charAt(i))) {
                cows.add(userNumber.charAt(i));
            }
        }
        return Arrays.asList(bulls.size(), cows.size());
    }
}
