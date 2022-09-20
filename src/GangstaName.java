import java.util.Scanner;

public class GangstaName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Type your name, playa: ");

        String name = console.nextLine();

        String firstInitial = name.charAt(0) + ".";
        String firstName = name.substring(0, name.indexOf(" "));
        String lastName = name.substring(name.indexOf(" ") + 1);
        lastName = lastName.toUpperCase();

        System.out.println(firstInitial + " Diddy" + lastName + firstName + "-izzle");
    }
}