package games;

import java.util.Random;
import java.util.Scanner;

public class NOKGame implements Games{
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

    @Override
    public boolean runGame(Scanner scanner, Random random) {
        System.out.println("Find the smallest common multiple of given numbers.");
        int firstNumber = random.nextInt(101);
        int secondNumber = random.nextInt(101);
        int thirdNumber = random.nextInt(101);
        System.out.println("Question: " + firstNumber + " " + secondNumber + " " + thirdNumber);
        System.out.print("Your answer: ");
        String stringAnswer = scanner.nextLine();
        answer = Integer.parseInt(stringAnswer);
        correctAnswer = getSmallestCommonMultiple(firstNumber, secondNumber, thirdNumber);
        return correctAnswer == answer;
    }

    private static int getSmallestCommonMultiple(int firstNumber, int secondNumber, int thirdNumber) {
        return getSCMForTwoNumbers(getSCMForTwoNumbers(firstNumber, secondNumber), thirdNumber);
    }

    private static int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
        while (secondNumber != 0) {
            int temp = secondNumber;
            secondNumber = firstNumber % secondNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    private static int getSCMForTwoNumbers(int firstNumber, int secondNumber) {
        return (firstNumber * secondNumber) / getGreatestCommonDivisor(firstNumber, secondNumber);
    }

}


