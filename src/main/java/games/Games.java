package games;

import java.util.Random;
import java.util.Scanner;

public interface Games {
    public boolean runGame(Scanner scanner, Random random);

    public int getCorrectAnswer();

    public int getAnswer();
}
