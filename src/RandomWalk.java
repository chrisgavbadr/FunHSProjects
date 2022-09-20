/* RandomWalk.java
 *
 * Christian Baduria, Java 2017
 * Ch 5 Project (Random Walk), 12/8/17
 *
 * This program performs random walks with a walker intially
 * positioned on the center of the circle. The user is prompted
 * for the step size and radius of a circle and a random walk will
 * be performed and animated on a Drawing Panel. The walk continues
 * indefinitely until the walker has escaped the vicinity of the
 * circle, which will then report the total steps and ask the user
 * whether they want to perform another walk. The statistics will
 * be reported once the user is finished performing walks.
 */

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class RandomWalk {
    public static final boolean DEBUG = false;
    public static final boolean COLORFUL_PATH = true;
    public static final int DRAWING_PANEL_SIZE = 500;
    public static final int PANEL_SLEEP_TIME = 1;

    // Introduces program, performs random walks, and reports statistics
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        DrawingPanel panel = new DrawingPanel(DRAWING_PANEL_SIZE, DRAWING_PANEL_SIZE);
        Graphics g = panel.getGraphics();
        Point center = new Point();
        Point position = new Point();

        int totalWalks = 0;
        int totalSteps = 0;
        int minStepsInWalk = 0;
        String walkAgain;

        introduceRandomWalk();

        do {
            int totalStepsInWalk = recordUserInput(console, panel, g, rand, center, position);
            if (totalStepsInWalk < minStepsInWalk || totalWalks == 0)
                minStepsInWalk = totalStepsInWalk;
            totalSteps += totalStepsInWalk;
            totalWalks++;
            walkAgain = console.next().toLowerCase();
        } while (walkAgain.charAt(0) == 'y');

        reportStatistics(totalWalks, totalSteps, minStepsInWalk);
    }

    // Introduces RandomWalk
    public static void introduceRandomWalk() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("*+====------- Christian's Random Walk Simulator -------====+*");
        System.out.println("-------------------------------------------------------------");
        System.out.println("\nWelcome! This program performs random walks with a walker");
        System.out.println("intially positioned on the center of the circle. You will");
        System.out.println("specify the walker's step size and the radius of the circle");
        System.out.println("that it has to escape. The walker will start walking");
        System.out.println("indefinitely in random directions within the circle until the");
        System.out.println("walker has escaped the vicinity of the circle. Your number of");
        System.out.println("moves taken will be reported and you'll be asked whether you");
        System.out.println("want to perform another walk. Your overall statistics will be");
        System.out.println("reported once you're finished performing all your walks.\n");
        System.out.println("-------------------------------------------------------------");
    }

    // Prompts for step size and radius, then reports total steps and prompts for rewalk
    public static int recordUserInput(Scanner console, DrawingPanel panel, Graphics g,
                                      Random rand, Point center, Point position) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, DRAWING_PANEL_SIZE, DRAWING_PANEL_SIZE);

        System.out.print("\nStep size? ");
        int stepSize = console.nextInt();
        System.out.print("Radius? ");
        int radius = console.nextInt();

        g.setColor(Color.BLACK);
        g.drawOval(0, 0, 2 * radius, 2 * radius);

        center.setLocation(radius, radius);
        position.setLocation(center);

        int totalSteps = performRandomWalk(panel, g, rand, center, position, stepSize, radius);

        System.out.printf("I escaped in %d move(s).\n", totalSteps);
        System.out.print("Walk again (yes/no)? ");

        return totalSteps;
    }

    // Performs and animates walk on Drawing Panel
    public static int performRandomWalk(DrawingPanel panel, Graphics g, Random rand, Point center,
                                        Point position, int stepSize, int radius) {
        int totalSteps = 0;
        double distance = 0;

        while (distance < radius) {
            if (COLORFUL_PATH)
                randomizeColor(g, rand);

            randomizeDirection(g, rand, position, stepSize);

            distance = position.distance(center);
            totalSteps++;
            panel.sleep(PANEL_SLEEP_TIME);
            if (DEBUG)
                System.out.printf("%s; Distance = %.2f; Move %d\n", position.toString(), distance, totalSteps);
        }

        return totalSteps;
    }

    // Randomizes walker's direction
    public static void randomizeDirection(Graphics g, Random rand, Point position, int stepSize) {
        int directionValue = rand.nextInt(4);
        int xPos = (int) position.getX();
        int yPos = (int) position.getY();

        if (directionValue == 0) {
            position.translate(0, -stepSize);
            g.fillRect(xPos, yPos - stepSize, stepSize, stepSize);
        } else if (directionValue == 1) {
            position.translate(0, stepSize);
            g.fillRect(xPos, yPos + stepSize, stepSize, stepSize);
        } else if (directionValue == 2) {
            position.translate(-stepSize, 0);
            g.fillRect(xPos - stepSize, yPos, stepSize, stepSize);
        } else {
            position.translate(stepSize, 0);
            g.fillRect(xPos + stepSize, yPos, stepSize, stepSize);
        }
    }

    // Randomizes walker's path color
    public static void randomizeColor(Graphics g, Random rand) {
        int redValue = rand.nextInt(256);
        int greenValue = rand.nextInt(256);
        int blueValue = rand.nextInt(256);

        Color randomColor = new Color(redValue, greenValue, blueValue);
        g.setColor(randomColor);
    }

    // Reports total walks performed, total steps taken, and best walk
    public static void reportStatistics(int totalWalks, int totalSteps, int minStepsInWalk) {
        System.out.println("\nTotal walks = " + totalWalks);
        System.out.println("Total steps = " + totalSteps);
        System.out.println("Best walk   = " + minStepsInWalk);
    }
}
