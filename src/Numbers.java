public class Numbers {
    public static void main(String[] args) {
        int number = 42;

        for (int i = 1; i <= 10; i++) {
            number = 37 * number % 103;
        }

        int number2 = number * number;

        System.out.println("result = " + number2);
    }
}