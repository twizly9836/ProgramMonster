import java.util.Random;
import java.util.Scanner;

public class SmartMonster extends Monster {
    SmartMonster(int sizeBoard) {
        super(sizeBoard);

        setImage("\uD83E\uDDE0");
    }
    @Override
    public boolean taskMonster(int difficultGame){
        if (difficultGame == 1) {
            return taskMonster();
        } else {
            System.out.println("Решите задачу:");
            Random random = new Random();




                        int a = random.nextInt(5 * (difficultGame - 1), 15 * difficultGame);
                        int b = random.nextInt(5 * (difficultGame - 1), 15 * difficultGame);
                        int c = random.nextInt(10 * (difficultGame - 1), 50 * difficultGame);
                        int d = random.nextInt(2, 6); //


                        int trueAnswer;
                        String expression;

                        if (random.nextBoolean()) {

                            trueAnswer = (a * b + c) / d;
                            expression = "(" + a + " * " + b + " + " + c + ") / " + d + " = ?";
                        } else {

                            int power = Math.min(b, 4);
                            trueAnswer = (int) Math.pow(a, power) - c;
                            expression = a + "^" + power + " - " + c + " = ?";
                        }

                        System.out.println("Реши пример: " + expression);

                        Scanner scanner = new Scanner(System.in);
                        int answer = Integer.parseInt(scanner.nextLine());

                        if (trueAnswer == answer) {
                            System.out.println("Верно! Ты победил умного монстра!");
                            return true;
                        } else {
                            System.out.println("Ты проиграл эту битву! Правильный ответ: " + trueAnswer);
                            return false;
                        }
                    }
                }

                public boolean taskMonster() {
                    return super.taskMonster(1);
                }
            }







