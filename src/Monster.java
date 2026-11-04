import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDDF";
    private final int x, y;

    Monster(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard - 1);
    }

    public int getX( ) {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean conflictPerson(int personX, int personY) {
        return personX == x && personY == y;
    }
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");

        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (trueAnswer ==  answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame >= 2) {
            Random random = new Random();
            String[] question = {
                    "Сколько будет 1980 * 1980?",
                    "Сколько планет в Солнечной системе?",
                    "Сколько будет 1586 + 1725?",
                    "На какую планету собираеться полететь Илон Макс?",
                    "Сколько будет 988 * 1488?",
                    "Сколько дней в високосном году?",
                    "Сколько будет 13 * 13",
                    "Как называеться спутник Земли",
                    "Сколько будет 1000 - 7",
                    "Сколько градусов в прямом угле?"
            };
            String[] trueAnswer = {
                    "3920400",
                    "8",
                    "3311",
                    "Макс",
                    "1470144",
                    "366",
                    "169",
                    "Луна",
                    "993",
                    "90"

            };

            int number = random.nextInt(question.length);
            System.out.println("Монстрик задает вопрос?");
            System.out.println(question[number]);
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (trueAnswer[number].equals(answer)) {
                System.out.println("Верно! Ты победил монстра");
                return true;

            } else {
                System.out.println("Ты проиграл эту битву!");
                System.out.println("Правильный ответ: " + trueAnswer[number]);
                return false;
            }
        } return false;
    }
}