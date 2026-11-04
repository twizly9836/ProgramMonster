import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        String castle = "\uD83C\uDFF0";
        int sizeBoard = 5;
        Person person = new Person(sizeBoard);
        String[][] board = new String[sizeBoard][sizeBoard];
        int castleY = 1;
        int castleX = 1 + random.nextInt(sizeBoard);
        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;





        int step = 0;


        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";

            }
        }

        board[castleY - 1][castleX - 1] = castle;
        board[person.getY() - 1][person.getX() - 1] = person.getImage();

        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        while (count < countMonster) {
            Monster monster;

            if (random.nextBoolean()) {
                monster = new Monster(sizeBoard);
            } else if (random.nextBoolean()) {
                monster = new BigMonster(sizeBoard);
            } else {
                monster = new SmartMonster(sizeBoard);
            }

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }



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

                    outputBoard(board, person.getLive());

                    /// ////////////////////////////////////////////////////



                    System.out.println("Введите куда будет ходить персонаж (ход возможен только по вертикали и горизонтали на одну клетку)");
                    System.out.println("Координаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    if (person.isMoveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";

                            person.move(x, y);
                            step++;
                            System.out.println(
                                    "Ход корректный; новые координаты: "
                                            + person.getX() + ", " + person.getY()
                                            + "\nХод номер: " + step
                            );
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            System.out.println("Решите задачу.");
                            for (Monster monster : monsters) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                        step++;
                                    } else {
                                        person.downLive();
                                    }
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Кординаты не изменены");
                    }

                    if (person.getLive() <= 0) {
                        break;
                    }
                }

                if (person.getLive() <= 0) {
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