import java.util.Scanner;

public class HailstoneGenerator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter in a Number to be Hailstoned: ");
        int number = console.nextInt();

        int steps = performHailstone(number);

        System.out.println();
        System.out.println("It took " + steps + " steps to reach 1.");
    }

    public static int performHailstone(int number) {
        int count = 0;

        do {
            if (number % 2 == 0)
                number /= 2;
            else
                number = 3 * number + 1;
            System.out.printf("-> %7d ", number);
            count++;
        } while (number != 1 && number > 0);

        return count;
    }
}