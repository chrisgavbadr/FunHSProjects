import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("This program reads data for two people and");
        System.out.println("computes their body mass index (BMI).\n");

        double person1BMI = calculateBMI(console);
        double person2BMI = calculateBMI(console);

        System.out.println("Person 1 BMI = " + person1BMI);
        status(person1BMI);
        System.out.println("Person 2 BMI = " + person2BMI);
        status(person2BMI);
    }

    public static double calculateBMI(Scanner console) {
        System.out.println("Enter next person's information:");
        System.out.print("height (in inches)? ");
        double height = console.nextDouble();
        System.out.print("weight (in pounds)? ");
        double weight = console.nextDouble();

        double bmi = (weight / (height * height)) * 703;
        return bmi;
    }

    public static void status(double bmi) {
        if (bmi < 18.5) {
            System.out.println("underweight");
        } else if (bmi < 25.0) {
            System.out.println("normal");
        } else if (bmi < 30.0) {
            System.out.println("overweight");
        } else {
            System.out.println("obese");
        }
    }
}