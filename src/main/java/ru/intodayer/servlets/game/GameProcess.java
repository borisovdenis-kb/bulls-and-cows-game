package ru.intodayer.servlets.game;

import javafx.util.Pair;
import ru.intodayer.servlets.game.exception.ValidationException;
import java.util.*;


public class GameProcess {
    private SecretNumber secretNumber;
    private List<Pair<String, BullsAndCows>> userAttempts;

    public GameProcess() {
        this.secretNumber = new SecretNumber();
        this.userAttempts = new ArrayList<>();
    }

    public String getSecretNumber() {
        return secretNumber.getNumber();
    }

    public List<Pair<String, BullsAndCows>> getUserAttempts() {
        return userAttempts;
    }

    public void addAttempt(String userAttempt, BullsAndCows bullsAndCows) {
        this.userAttempts.add(new Pair<>(userAttempt, bullsAndCows));
    }

    public BullsAndCows handleUserAttempt(String userNumber) throws ValidationException {
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
        BullsAndCows bullsAndCows = new BullsAndCows(bulls.size(), cows.size());
        this.addAttempt(
            userNumber,
            bullsAndCows
        );
        return bullsAndCows;
    }
}
