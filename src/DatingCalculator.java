import java.util.Scanner;

public class DatingCalculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        introduction();

        if ((holiday(console) || food(console)) && (subject(console) || number(console))) {
            System.out.println("Wanna go out and date?");
        } else {
            System.out.println("Nah... I'm not interested in you.");
        }
    }

    public static void introduction() {
        System.out.println("Welcome to my dating website! You'll");
        System.out.println("surveyed about your opinions and we will");
        System.out.println("determine whether you should date me!\n");
    }

    public static boolean holiday(Scanner console) {
        System.out.print("What is your favorite holiday?");
        String holiday = console.next().toUpperCase();

        return holiday.equals("CHRISTMAS");
    }

    public static boolean subject(Scanner console) {
        System.out.print("What is your prefered subject in school?");
        String subject = console.next().toUpperCase();

        return subject.equals("JAVA") || subject.equals("MATH") || subject.equals("PHYSICS");
    }

    public static boolean food(Scanner console) {
        System.out.print("What is your favorite food?");
        String food = console.next().toUpperCase();

        return food.equals("PIZZA") || food.equals("PASTA");
    }

    public static boolean number(Scanner console) {
        System.out.print("What is your favorite number?");
        int number = console.nextInt();

        return number == 42;
    }
}