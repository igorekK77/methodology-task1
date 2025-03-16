import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeometricProgressionGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameMenu.sayHelloAndNameUser(scanner);
        System.out.println("What number is missing in the progression?");

        boolean isFinishGame = startGame(scanner);
        while (!isFinishGame) {
            isFinishGame = startGame(scanner);
        }
    }

    public static List<Integer> generateGeometricProgression() {
        Random random = new Random();
        int length = random.nextInt(6) + 5;

        int firstElements = random.nextInt(10) + 1;
        int denominatorProgression = random.nextInt(4) + 2;

        List<Integer> progression = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            progression.add(firstElements * (int) Math.pow(denominatorProgression, i));
        }
        return progression;
    }

    public static boolean startGame(Scanner scanner) {
        List<Integer> progression = generateGeometricProgression();
        Random random = new Random();
        boolean isFinishGame = false;

        int hiddenIndex = random.nextInt(progression.size());
        int hiddenValue = progression.get(hiddenIndex);
        progression.set(hiddenIndex, null);

        System.out.print("Question: ");
        for (Integer value: progression) {
            if (value == null) {
                System.out.print(".. ");
            } else {
                System.out.print(value + " ");
            }
        }
        System.out.print("\n" + "Your answer: ");
        String answerString = scanner.nextLine();
        int answer = Integer.parseInt(answerString);

        if (answer == hiddenValue) {
            GameMenu.correctAnswer();
            isFinishGame = true;
        } else {
            GameMenu.notCorrectAnswer(answer, hiddenValue);
        }
        return isFinishGame;
    }
}
