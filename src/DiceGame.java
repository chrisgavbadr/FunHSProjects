import java.util.Random;

public class DiceGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int firstRoll = rand.nextInt();
        int secondRoll = rand.nextInt();
        int sum = 0;
        int numOfRolls = 0;

        do {
            firstRoll = rand.nextInt(6) + 1;
            secondRoll = rand.nextInt(6) + 1;
            sum = firstRoll + secondRoll;
            System.out.printf("\n%d + %d = %d", firstRoll, secondRoll, sum);
            numOfRolls++;
        } while (sum != 7);

        System.out.printf("\nYou won after %d tries!", numOfRolls);
    }
}