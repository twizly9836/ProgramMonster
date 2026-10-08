import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String person = "\uD83E\uDDD9";
        String monster = "\uD83E\uDDDF";
        String castle = "\uD83C\uDFF0";

        String leftBlock = " | ";
        String rightBlock = " | ";
        String wall = " + —— + —— + —— + —— + —— + ";
        int sizeBoard = 5;
        String[]  board = new String[sizeBoard * sizeBoard];
        int castleY = 1;
        int castleX = 1 + random.nextInt(sizeBoard);




        int personLive = 3;

        int personX;
        int personY;
        int step = 0;

        personX = 1;
        personY = sizeBoard;
        // \n, \t - спец символ
        String gamingField = "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    | " + monster + " |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "|    |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +\n"
                + "| " + person + " |    |    |    |    |\n"
                + "+ —— + —— + —— + —— + —— +";

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();



        System.out.println("Ваш ответ:\t" + answer);
        switch (answer) {
            case "ДА":
                System.out.println("Начинаем играть");

                while ((personLive > 0) && !(castleX == personX && castleY == personY)) {

                    /// ////////////////////////////////////////////////////
                    /*Вывод на экран игрового поля:*/

                    for (int y = 1; y <= sizeBoard; y++) {
                        for (int x = 1; x <= sizeBoard; x++) {
                            board[(y-1) * sizeBoard + x - 1] = "      ";

                            if (personY == y && personX == x) {
                            } else if (castleX == x && castleY == y) {
                            }else {
                            System.out.print("");
                            }

                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

                    /// ////////////////////////////////////////////////////



                    System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
                    System.out.println("Координаты персонажа - (x: " + personX + ", y: " + personY + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (x != personX && y != personY) {
                        System.out.println("Некорректный ход");
                    } else if (Math.abs(x - personX) == 1) {
                        personX = x;
                        step += 1;
                    } else if (Math.abs(y - personY) == 1) {
                        personY = y;
                        step += 1;
                    } else {
                        System.out.println("Координаты не изменены");

                    }
                }

                break;
            case "НЕТ":
                System.out.println("Почему ты не захотел со мной играть :(");
                System.out.println("Приходи ещё!");
                break;
            default:
                System.out.println("Данные введены некорректно");
        }
    }
}