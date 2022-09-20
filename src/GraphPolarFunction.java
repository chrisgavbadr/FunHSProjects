import java.awt.*;

public class GraphPolarFunction {
    public static final int SIZE = 500;
    public static final int QUALITY = 4;
    public static final int POINT_RADIUS = 10;
    public static final int X_SHIFT = 0;
    public static final int Y_SHIFT = 0;
    public static final double SCALE = 3;
    public static final boolean COORDINATE_GRID = true;
    public static final boolean ANIMATE_GRAPH = false;

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(SIZE, SIZE);
        Graphics g = panel.getGraphics();

        double equation;

        // Draws coordinate grid
        if (COORDINATE_GRID) {
            Color grey = new Color(0.8f, 0.8f, 0.8f, 1f);
            g.setColor(grey);
            for (int i = 0; i <= POINT_RADIUS; i++)
                g.drawLine(0, i * SIZE / POINT_RADIUS, SIZE, i * SIZE / POINT_RADIUS);

            for (int i = 0; i <= POINT_RADIUS; i++)
                g.drawLine(i * SIZE / POINT_RADIUS, 0, i * SIZE / POINT_RADIUS, SIZE);
            g.setColor(Color.BLACK);
            g.fillRect(SIZE / 2 - 1, 0, 3, SIZE);
            g.fillRect(0, SIZE / 2 - 1, SIZE, 3);
        }

        // Finds distance as a function of the angle and plots it
        for (double a = 0; a <= 2 * Math.PI; a += 1.0 / Math.pow(10, QUALITY)) {
            // Plug in equation here
            equation = 6 * Math.sin(Math.cos(Math.sin(3 * a))) - 3.75;
            dagSxSyw(g, equation * (SIZE / SCALE), -a);
            if (ANIMATE_GRAPH) {
                panel.sleep(1);
            }
        }
    }

    // Plots a point given an angle, distance, an x and y shift, the DrawingPanel SCALE, and the POINT_RADIUS
    public static void dagSxSyw(Graphics g, double d, double a) {
        g.fillOval((int) (SIZE / 2 + d * Math.cos(a) + X_SHIFT * (SIZE / SCALE) - POINT_RADIUS / 2) + 1,
                (int) (SIZE / 2 + d * Math.sin(a) - Y_SHIFT * (SIZE / SCALE) - POINT_RADIUS / 2) + 1, POINT_RADIUS, POINT_RADIUS);
    }
}