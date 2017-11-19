package ru.intodayer.servlets;

import ru.intodayer.servlets.utility.BullsAndCowsGame;

import java.util.Scanner;


public class TestGameLogic {
    public static void main(String[] args) {
        BullsAndCowsGame game = new BullsAndCowsGame();
        Scanner sc = new Scanner(System.in);

        System.out.println(game.getSecretNumber());

        while (true) {
            System.out.print(": ");
            String number = sc.nextLine();
            System.out.println(game.handleUserAttempt(number));
        }
    }
}
