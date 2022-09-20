public class WarmUpChallenge1 {
    public static void main(String[] args) {
        printNumbers(5);
        printPrimes(38);
    }

    public static void printNumbers(int max) {
        for (int i = 1; i < max; i++) {
            System.out.printf("%d, ", i);
        }
        System.out.println(max);
    }

    public static void printPrimes(int max) {
        if (max >= 2) {
            System.out.print(2);
            for (int i = 3; i <= max; i++) {
                int numOfFactors = countFactors(i);
                if (numOfFactors == 0) {
                    System.out.printf(", %d", i);
                }
            }
        }
    }

    public static int countFactors(int number) {
        int count = 0;
        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                count++;
            }
        }
        return count;
    }
}