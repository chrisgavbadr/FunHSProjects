import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int daysAboveAvg = 0;
        double avgTemp = 0;
        int[] coldestTemps = new int[2];
        int[] hottestTemps = new int[2];

        System.out.print("How many days' temperatures? ");
        int days = console.nextInt();
        int[] temps = new int[days];

        for (int i = 0; i < days; i++) {
            System.out.printf("Day %d's high temp: ", i + 1);
            temps[i] = console.nextInt();
            avgTemp += temps[i];
        }
        avgTemp /= temps.length;

        for (int n : temps) {
            if (n > avgTemp)
                daysAboveAvg++;
        }
        System.out.printf("Average temp = %.1f\n", avgTemp);
        System.out.printf("%d days were above average.\n", daysAboveAvg);
    }
}