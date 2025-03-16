import java.util.Scanner;

public class GameMenu {
    private static String name;

    public static void sayHelloAndNameUser(Scanner scanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    public static void correctAnswer() {
        System.out.println("Correct!");
        System.out.println("Congratulations, " + name + "!");
    }

    public static void notCorrectAnswer(int answerUser, int correctNumber) {
        System.out.println("'" + answerUser + "' is wrong answer ;(. Correct answer was '" +
                correctNumber + "'");
        System.out.println("Let's try again, " + name + "!");
    }
}
