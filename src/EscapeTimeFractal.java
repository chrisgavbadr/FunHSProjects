import java.awt.*;
import java.util.Scanner;

public class EscapeTimeFractal {
    // Graph Display Settings
    public static final boolean COORDINATE_GRID = false;
    public static final double X_MIN = -2;
    public static final double X_MAX = 2;
    public static final double Y_MIN = -2;
    public static final double Y_MAX = 2;
    public static final int WINDOW_LENGTH = 600;

    // Fractal Display Settings
    public static final boolean JULIA_SET = false;
    public static final boolean BURNING_SHIP = false;
    public static final int ITERATIONS = 1000;
    public static final int CLARITY = ITERATIONS;
    /* 1 = Red  | 2 = Yellow | 3 = Green | 4 = Cyan |
     * 5 = Blue | 6 = Violet | 7 = White | */
    public static final int COLOR = 4;

    // Dependent Constants
    public static final double X_RANGE = X_MAX - X_MIN;
    public static final double Y_RANGE = Y_MAX - Y_MIN;
    public static final int WINDOW_WIDTH = (int) (WINDOW_LENGTH * (Y_RANGE / X_RANGE));
    public static final double X_SCALE = WINDOW_LENGTH / X_RANGE;
    public static final double Y_SCALE = WINDOW_WIDTH / Y_RANGE;

    // Central Function
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        DrawingPanel panel = new DrawingPanel(WINDOW_LENGTH + 1, WINDOW_WIDTH + 1);
        Graphics g = panel.getGraphics();
        Complex c = new Complex(0, 0);
        Complex z;

        if (COORDINATE_GRID)
            drawComplexPlane(panel, g);
        if (JULIA_SET) {
            System.out.println("Enter a Complex Number for c");
            c = getComplexValue(console);
            System.out.println("c = " + c.toString());
            System.out.println();
        }
        drawFractalSet(g, c);

        System.out.print("Trace a Point? ");
        String traceAgain = console.next().toLowerCase();
        while (traceAgain.charAt(0) == 'y') {
            System.out.println();
            System.out.println("Enter a Complex Tracing Value for z");
            z = getComplexValue(console);
            System.out.println("z = " + z.toString());
            int iterationZ = tracePoint(g, c, z);
            System.out.println("Iteration at which z escapes: " + iterationZ);
            System.out.print("Trace Another Point? ");
            traceAgain = console.next().toLowerCase();
        }
    }

    // Prompts for a Complex Value
    public static Complex getComplexValue(Scanner console) {
        System.out.print("Real Part: ");
        double realPart = console.nextDouble();
        System.out.print("Imaginary Part: ");
        double imaginaryPart = console.nextDouble();

        Complex z = new Complex(realPart, imaginaryPart);
        return z;
    }

    // Draws the complex plane with a real- and imaginary-axis
    public static void drawComplexPlane(DrawingPanel panel, Graphics g) {
        g.setColor(Color.GRAY);

        for (double i = Math.floor(X_MIN); i <= X_MAX; i++)
            g.drawLine((int) (X_SCALE * (i - X_MIN)), 0, (int) (X_SCALE * (i - X_MIN)), WINDOW_WIDTH);

        for (double i = Math.floor(Y_MIN); i <= Y_MAX; i++)
            g.drawLine(0, -(int) (Y_SCALE * (i - Y_MIN)) + WINDOW_WIDTH,
                    WINDOW_LENGTH, -(int) (Y_SCALE * (i - Y_MIN)) + WINDOW_WIDTH);

        g.setColor(Color.BLACK);
        g.fillRect(-(int) (X_SCALE * X_MIN) - 1, 0, 3, WINDOW_WIDTH + 1);
        g.fillRect(0, (int) (Y_SCALE * Y_MAX) - 1, WINDOW_LENGTH + 1, 3);
    }

    // Draws a fractal set
    public static void drawFractalSet(Graphics g, Complex c) {
        for (int i = (int) (X_SCALE * X_MIN); i < X_SCALE * X_MAX; i++) {
            for (int j = (int) (Y_SCALE * Y_MIN); j < Y_SCALE * Y_MAX; j++) {
                double realPart = X_RANGE * i / WINDOW_LENGTH;
                double imaginaryPart = Y_RANGE * j / WINDOW_WIDTH;
                Complex z = new Complex(realPart, imaginaryPart);
                int iteration = iterateFunction(z, c);

                determineColor(g, iteration);
                g.fillOval((int) (i - X_SCALE * X_MIN), (int) (-j + Y_SCALE * Y_MIN + WINDOW_WIDTH), 1, 1);
            }
        }
    }

    // Determines the iteration at which a point escapes
    public static int iterateFunction(Complex z, Complex c) {
        if (!JULIA_SET)
            c = z;

        if (!BURNING_SHIP) {
            for (int i = 0; i < ITERATIONS; i++) {
                if (z.abs() > 2)
                    return i;
                z = z.times(z).plus(c);
            }
        } else {
            for (int i = 0; i < ITERATIONS; i++) {
                if (z.abs() > 2)
                    return i;
                Complex zAbs = new Complex(Math.abs(z.re()), Math.abs(z.im()));
                z = zAbs.times(zAbs).plus(c);
            }
        }

        return ITERATIONS;
    }

    public static int tracePoint(Graphics g, Complex c, Complex z1) {
        if (!JULIA_SET)
            c = z1;
        int iteration = 0;

        g.setColor(Color.WHITE);
        g.fillOval((int) (Math.abs(X_SCALE * X_MIN) + X_SCALE * z1.re() - 2),
                (int) (Math.abs(Y_SCALE * Y_MAX) - Y_SCALE * z1.im() - 2), 5, 5);
        g.setColor(Color.BLACK);
        for (int i = 0; i < 4 * ITERATIONS; i++) {
            if (z1.abs() < 2)
                iteration++;
            Complex z0 = new Complex(z1.re(), z1.im());
            z1 = z0.times(z0).plus(c);
            g.drawLine((int) (Math.abs(X_SCALE * X_MIN) + X_SCALE * z0.re()),
                    (int) (Math.abs(Y_SCALE * Y_MAX) - Y_SCALE * z0.im()),
                    (int) (Math.abs(X_SCALE * X_MIN) + X_SCALE * z1.re()),
                    (int) (Math.abs(Y_SCALE * Y_MAX) - Y_SCALE * z1.im()));
        }

        return iteration;
    }

    // Determines the color for a point
    public static void determineColor(Graphics g, int iteration) {
        if (iteration == ITERATIONS)
            g.setColor(Color.BLACK);
        else {
            if (COLOR == 1) {
                Color color = new Color(25 + (int) (iteration % CLARITY * (230.0 / CLARITY)), 0, 0);
                g.setColor(color);
            } else if (COLOR == 2) {
                Color color = new Color(25 + (int) (iteration % CLARITY * (230.0 / CLARITY)),
                        25 + (int) (iteration % CLARITY * (230.0 / CLARITY)), 0);
                g.setColor(color);
            } else if (COLOR == 3) {
                Color color = new Color(0, 25 + (int) (iteration % CLARITY * (230.0 / CLARITY)), 0);
                g.setColor(color);
            } else if (COLOR == 4) {
                Color color = new Color(0, 25 + (int) (iteration % CLARITY * (230.0 / CLARITY)),
                        25 + (int) (iteration % CLARITY * (230.0 / CLARITY)));
                g.setColor(color);
            } else if (COLOR == 5) {
                Color color = new Color(0, 0, 25 + (int) (iteration % CLARITY * (230.0 / CLARITY)));
                g.setColor(color);
            } else if (COLOR == 6) {
                Color color = new Color(25 + (int) (iteration % CLARITY * (230.0 / CLARITY)), 0,
                        25 + (int) (iteration % CLARITY * (230.0 / CLARITY)));
                g.setColor(color);
            } else {
                Color color = new Color(25 + (int) (iteration % CLARITY * (230.0 / CLARITY)),
                        25 + (int) (iteration % CLARITY * (230.0 / CLARITY)),
                        25 + (int) (iteration % CLARITY * (230.0 / CLARITY)));
                g.setColor(color);
            }
        }
    }
}