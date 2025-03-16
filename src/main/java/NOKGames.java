import java.util.Random;
import java.util.Scanner;

public class NOKGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Find the smallest common multiple of given numbers.");
        while (true) {
            int firstNumber = random.nextInt(101);
            int secondNumber = random.nextInt(101);
            int thirdNumber = random.nextInt(101);
            System.out.println("Question: " + firstNumber + " " + secondNumber + " " + thirdNumber);
            System.out.print("Your answer: ");
            String stringAnswer = scanner.nextLine();
            int answer = Integer.parseInt(stringAnswer);

            if (getSmallestCommonMultiple(firstNumber, secondNumber, thirdNumber) == answer) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" +
                        getSmallestCommonMultiple(firstNumber, secondNumber, thirdNumber) + "'");
                System.out.println("Let's try again, " + name + "!");
            }
        }
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


