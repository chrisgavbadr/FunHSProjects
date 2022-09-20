import java.util.Random;
import java.util.Scanner;

public class AddingGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        int wrong = 0;
        int score = 0;

        while (wrong < 3) {
            int result = play(console, rand);
            if (result > 0) {
                score++;
            } else {
                wrong++;
            }
        }
        System.out.println("You earned " + score + " total points.");
    }

    public static int play(Scanner console, Random rand) {
        int operands = rand.nextInt(4) + 2;
        int sum = rand.nextInt(10) + 1;
        System.out.print(sum);

        for (int i = 2; i <= operands; i++) {
            int randNum = rand.nextInt(10) + 1;
            sum += randNum;
            System.out.print(" + " + randNum);
        }
        System.out.print(" = ");

        int userAnswer = console.nextInt();
        if (userAnswer == sum) {
            return 1;
        } else {
            System.out.println("Wrong! The answer was " + sum);
            return 0;
        }
    }
}