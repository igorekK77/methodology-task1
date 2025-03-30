import engine.Engine;
import games.Games;
import games.GeometricProgressionGame;
import games.NOKGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Engine engine = new Engine();
        Games game;
        System.out.print("Меню: \n" +
                "Выберите необходимую опцию: \n" +
                "1 - Запустить игру НОК (наименьшее общее кратное) \n" +
                "2 - Запустить игру Геометрическая прогрессия \n" +
                "0 - Выйти \n" +
                "Введите номер: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            game = new NOKGame();
        } else if (choice.equals("2")) {
            game = new GeometricProgressionGame();
        } else {
            System.out.println("Работа программы завершена");
            return;
        }
        engine.startGames(game);
    }
}
