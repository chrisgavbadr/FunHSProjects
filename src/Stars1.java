public class Stars1 {
    public static void main(String[] args) {
        line(100);
        box(8, 7);
        line();
        box();
        repeat("$9,000,000,000,000 + ", 3);
    }

    public static void line(int length) {
        for (int i = 1; i <= length; i++) {
            System.out.print("*");
        }

        System.out.println();
    }

    public static void line() {
        line(10);
    }

    public static void box(int length, int width) {
        line(length);

        for (int i = 1; i <= (width - 2); i++) {
            System.out.print("*");

            for (int j = 1; j <= (length - 2); j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }

        line(length);

        System.out.println();
    }

    public static void box() {
        box(8, 10);
    }

    public static void repeat(String string, int repetitions) {
        for (int i = 1; i <= repetitions; i++) {
            System.out.print(string);
        }
        System.out.println();
    }
}