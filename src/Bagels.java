/* Bagels.java
 *
 * Christian Baduria, Java 2018
 * Ch 7 Project (Bagels), 1/19/18
 *
 * This program plays a guessing game with the user. A random
 * number with LENGTH number of digits whose digits are
 * between 1 and 9 is generated by the program. The user is
 * then prompted to guess the answer while they're given
 * clues every wrong answer. They indicate whether a correct
 * digit is in the right place, in the wrong place, or if all
 * the digits are incorrect per wrong answer. The number of
 * guesses are reported and prompted the user whether to play
 * another game.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bagels {
    public static final int LENGTH = 4;

    // Introduces Bagels, plays guessing game, and provides clues
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        int[] answer = new int[LENGTH];

        introduceBagels();

        do {
            for (int i = 0; i < LENGTH; i++) {
                answer[i] = rand.nextInt(9) + 1;
            }

            int guesses = playGuessingGame(console, answer);

            System.out.println("You got it right in " + guesses + " guesses.\n");
            System.out.print("Do you want to play again? ");
        } while (console.next().toLowerCase().charAt(0) == 'y');
    }

    // Introduces Bagels
    public static void introduceBagels() {
        System.out.println("Welcome to Java Bagels!");
        System.out.println("I'm thinking of a " + LENGTH + " digit number.");
        System.out.println("Each digit is between 1 and 9.");
        System.out.println("Try to guess my number, and I'll say \"fermi\"");
        System.out.println("for each digit you get right, and \"pica\"");
        System.out.println("for each correct digit in the wrong place.\n");
    }

    // Converts a number into an array of its digits
    public static int[] convertIntoDigitArray(int number) {
        int[] digitArray = new int[LENGTH];

        for (int i = (LENGTH - 1); i >= 0; i--) {
            digitArray[i] = number % 10;
            number /= 10;
        }

        return digitArray;
    }

    // Prompted the user to guess a number
    public static int playGuessingGame(Scanner console, int[] answer) {
        int[] guess;
        int guesses = 1;

        System.out.print("Your guess? ");
        guess = convertIntoDigitArray(console.nextInt());

        while (!Arrays.equals(guess, answer)) {
            provideClues(guess, Arrays.copyOf(answer, LENGTH));
            guesses++;
            System.out.print("Your guess? ");
            guess = convertIntoDigitArray(console.nextInt());
        }

        return guesses;
    }

    // Determines and provides user with appropriate clues
    public static void provideClues(int[] guess, int[] answer) {
        boolean bagels = true;

        for (int i = 0; i < LENGTH; i++) {
            if (answer[i] == guess[i]) {
                System.out.print("fermi ");
                bagels = false;
                answer[i] = -1;
                guess[i] = 0;
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (answer[i] == guess[j]) {
                    System.out.print("pica ");
                    bagels = false;
                    answer[i] = -1;
                    guess[j] = 0;
                }
            }
        }

        if (bagels)
            System.out.print("bagels");
        System.out.println();
    }
}