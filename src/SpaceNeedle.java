/* SpaceNeedle.java
 *
 * Christian Baduria, Java 2017
 * Ch 2 Project (Space Needle), 9/24/17
 *
 * This program prints out a Space Needle given
 * a size factor inputted internally by a user.
 */

public class SpaceNeedle {
    // Adjustable Size
    public static final int SIZE = 3;

    // Prints out Space Needle by calling their counterpart methods
    public static void main(String[] args) {
        antenna();
        mainBody();
        lowerBody();
        antenna();
        midsection();
        mainBody();
    }

    // Prints out the antenna
    public static void antenna() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= (3 * SIZE); j++) {
                System.out.print(" ");
            }

            System.out.print("||");
            System.out.println();
        }
    }

    // Prints out the the main body (also used as the base)
    public static void mainBody() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= (-3 * i + 3 * SIZE); j++) {
                System.out.print(" ");
            }

            System.out.print("__/");

            for (int j = 1; j <= (3 * i - 3); j++) {
                System.out.print(":");
            }

            System.out.print("||");

            for (int j = 1; j <= (3 * i - 3); j++) {
                System.out.print(":");
            }

            System.out.print("\\__");
            System.out.println();
        }

        System.out.print("|");

        for (int i = 1; i <= (6 * SIZE); i++) {
            System.out.print("\"");
        }

        System.out.print("|");
        System.out.println();
    }

    // Prints out the lower body
    public static void lowerBody() {
        for (int i = 1; i <= SIZE; i++) {
            for (int j = 1; j <= (2 * i - 2); j++) {
                System.out.print(" ");
            }

            System.out.print("\\_");

            for (int j = 1; j <= (-2 * i + 3 * SIZE + 1); j++) {
                System.out.print("/\\");
            }

            System.out.print("_/");
            System.out.println();
        }
    }

    // Prints out the midsection
    public static void midsection() {
        for (int i = 1; i <= (SIZE * SIZE); i++) {
            for (int j = 1; j <= (2 * SIZE + 1); j++) {
                System.out.print(" ");
            }

            System.out.print("|");

            for (int j = 1; j <= (SIZE - 2); j++) {
                System.out.print("%");
            }

            System.out.print("||");

            for (int j = 1; j <= (SIZE - 2); j++) {
                System.out.print("%");
            }

            System.out.print("|");
            System.out.println();
        }
    }
}
