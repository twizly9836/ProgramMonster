import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        //String person = "\uD83E\uDDD9";
        String monster = "\uD83E\uDDDF";
        String castle = "\uD83C\uDFF0";

        String leftBlock = " | ";
        String rightBlock = " | ";
        String wall = " + —— + —— + —— + —— + —— + ";
        int sizeBoard = 5;
        Person person = new Person(sizeBoard);
        String[][] board = new String[sizeBoard][sizeBoard];
        int castleY = 1;
        int castleX = 1 + random.nextInt(sizeBoard);
        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;




        int personLive = 3;


        int step = 0;


        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";

            }
        }
        for (int i = 0; i < countMonster; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
        }
        board[castleY - 1][castleX - 1] = castle;
        board[person.getY() - 1][person.getX - 1] = person.image;


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
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);

                System.out.println("Начинаем играть");



                while (true) {

                    /// ////////////////////////////////////////////////////
                    /*Вывод на экран игрового поля:*/

                    for (int y = 1; y <= sizeBoard; y++) {
                        System.out.println(wall);
                        for (int x = 1; x <= sizeBoard; x++) {
                            System.out.print(leftBlock);
                            System.out.print(board[y - 1][x - 1]);
                        }
                        System.out.println(rightBlock);
                    }
                    System.out.println(wall);

                    /// ////////////////////////////////////////////////////



                    System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
                    System.out.println("Координаты персонажа - (x: " + person.x + ", y: " + person.y + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (person.isMoveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.y - 1][person.x - 1] = "  ";

                            person.move(x, y);
                            step++;
                            System.out.println(
                                    "Ход корректный; новые координаты: "
                                            + person.x + ", " + person.y
                                            + "\nХод номер: " + step
                            );
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            System.out.println("Решите задачу.");
                            if (taskMonster(difficultGame)) {
                                board[person.y - 1][person.x - 1] = "  ";
                                person.x = x;
                                person.y = y;
                                step++;
                            } else {
                                personLive--;
                            }

                        }
                    } else {
                        System.out.println("Кординаты не изменены");
                    }

                    if (personLive <= 0) {
                        break;
                    }
                }

                if (personLive <= 0) {
                    System.out.println("Закончились жизни. Итог: ...");
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

    static boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;
            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {
            /// /////
            return true;
            }
        }
        static void outputBoard(String[][] board, int live) {
            String leftBlock = "| ";
            String rightBlock = "|";
            String wall = "+ —— + —— + —— + —— + —— +";

            for (String[] row : board) {
                System.out.println(wall);
                for (String col : row) {
                    System.out.print(leftBlock + col + " ");
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);

            System.out.println("Количество жизней:\t" + live + "\n");

    }
}