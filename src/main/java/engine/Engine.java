package engine;

import games.Games;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private String name;

    public void startGames(Games game) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int countWinGame = 0;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        while (countWinGame != 3) {
            boolean isFinishGame = game.runGame(scanner, random);
            if (!isFinishGame) {
                countWinGame = 0;
                System.out.println("'" + game.getAnswer() + "' is wrong answer ;(. Correct answer was '" +
                        game.getCorrectAnswer() + "'");
                System.out.println("Let's try again, " + name + "!");
            } else {
                countWinGame++;
                System.out.println("Correct!");
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
