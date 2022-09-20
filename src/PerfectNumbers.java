public class PerfectNumbers {
    public static void main(String[] args) {
        perfectNumbers(500);
    }

    public static void perfectNumbers(int max) {
        int factorSum = 0;
        System.out.print("Perfect Numbers up to " + max + ": ");

        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= (i - 1); j++) {
                if (i % j == 0) {
                    factorSum += j;
                }
            }
            if (factorSum == i) {
                System.out.print(factorSum + " ");
            }

            factorSum = 0;
        }
    }
}