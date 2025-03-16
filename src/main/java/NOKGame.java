import java.util.Random;
import java.util.Scanner;

public class NOKGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        GameMenu.sayHelloAndNameUser(scanner);
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
                GameMenu.correctAnswer();
                break;
            } else {
                GameMenu.notCorrectAnswer(answer, getSmallestCommonMultiple(firstNumber, secondNumber, thirdNumber));
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


