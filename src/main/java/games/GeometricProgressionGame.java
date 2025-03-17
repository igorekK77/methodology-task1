package games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeometricProgressionGame implements Games{

    private int correctAnswer;
    private int answer;

    @Override
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public int getAnswer() {
        return answer;
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

    @Override
    public boolean runGame(Scanner scanner, Random random) {
        System.out.println("What number is missing in the progression?");
        List<Integer> progression = generateGeometricProgression();

        int hiddenIndex = random.nextInt(progression.size());
        correctAnswer = progression.get(hiddenIndex);
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
        answer = Integer.parseInt(answerString);

        return answer == correctAnswer;
    }
}
