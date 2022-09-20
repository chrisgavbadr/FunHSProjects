import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.util.Scanner;

public class GraphFunction {
    // Graph Display Settings
    public static final double QUALITY = 7.5;
    public static final double X_MIN = -18.34;
    public static final double X_MAX = 17.75;
    public static final double Y_MIN = -13.45;
    public static final double Y_MAX = 14.67;
    public static final int WINDOW_LENGTH = 400;
    public static final int WINDOW_WIDTH = 500;

    // Dependent Constants
    public static final double X_SCALE = WINDOW_LENGTH / (X_MAX - X_MIN);
    public static final double Y_SCALE = WINDOW_WIDTH / (Y_MAX - Y_MIN);

    // Miscellaneous Settings
    public static final boolean GRAPH_INVERSE = false;
    public static final boolean SHOW_TABLE = true;
    public static final boolean ANIMATE_GRAPH = true;

    // Central Function
    public static void main(String[] args) throws ScriptException {
        Scanner console = new Scanner(System.in);
        DrawingPanel panel = new DrawingPanel(WINDOW_LENGTH + 1, WINDOW_WIDTH + 1);
        Graphics g = panel.getGraphics();

        drawGraph(panel, g);

        System.out.print("f(x) = ");
        String function = console.nextLine();

        displayTable(function);
        graphFunction(panel, g, function, Color.BLUE, Color.RED);
    }

    // Draws a coordinate grid with an x- and y-axis
    public static void drawGraph(DrawingPanel panel, Graphics g) {
        g.setColor(Color.GRAY);

        for (double i = Math.floor(X_MIN); i <= X_MAX; i++)
            g.drawLine((int) (X_SCALE * (i - X_MIN)), 0, (int) (X_SCALE * (i - X_MIN)), WINDOW_WIDTH);

        for (double i = Math.floor(Y_MIN); i <= Y_MAX; i++)
            g.drawLine(0, -(int) (Y_SCALE * (i - Y_MIN)) + WINDOW_WIDTH,
                    WINDOW_LENGTH, -(int) (Y_SCALE * (i - Y_MIN)) + WINDOW_WIDTH);

        g.setColor(Color.BLACK);
        g.fillRect(-(int) (X_SCALE * X_MIN) - 1, 0, 3, WINDOW_WIDTH + 1);
        g.fillRect(0, (int) (Y_SCALE * Y_MAX), WINDOW_LENGTH + 1, 3);
    }

    // Graphs a function onto the DrawingPanel
    public static void graphFunction(DrawingPanel panel, Graphics g, String function,
                                     Color graphColor, Color inverseColor) throws ScriptException {
        double y;
        g.setColor(graphColor);

        for (double x = X_MIN; x <= X_MAX + 0.01; x += 1.0 / Math.pow(2, QUALITY)) {
            y = evaluateFunction(function, x);

            g.fillOval((int) (X_SCALE * (x - X_MIN)) - 1, (int) (-Y_SCALE * (y - Y_MAX)), 3, 3);
            if (GRAPH_INVERSE) {
                g.setColor(inverseColor);
                g.fillOval((int) (-X_SCALE * (y - Y_MAX)) - 1, (int) (Y_SCALE * (x - X_MIN)) - 1, 3, 3);
                g.setColor(graphColor);
            }

            if (ANIMATE_GRAPH)
                panel.sleep(1);
        }
    }

    // Prints out a table of the function
    public static void displayTable(String function) throws ScriptException {
        System.out.println("_____________________________________");
        System.out.println("|\tX\t|\tY\t|");
        System.out.println("|-----------------|-----------------|");
        double y;

        for (double x = -10; x <= 10; x++) {
            y = evaluateFunction(function, x);
            System.out.printf("|%14.1f\t|%14.1f\t|      \n", x, y);
        }

        System.out.println("|_________________|_________________|");
    }

    // Allows the function to be evaluated from a string
    public static double evaluateFunction(String function, double input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        function = substituteInput(function, input);
        return (double) engine.eval(function);
    }

    // Substitutes the input x into the function
    public static String substituteInput(String function, double input) {
        function = function.replace(" ", "");

        for (int i = 0; i < function.length(); i++) {
            if (function.charAt(i) == 'x' || function.charAt(i) == 'X') {
                function = function.substring(0, i) + input + function.substring(i + 1);
            }
        }

        return function;
    }
}