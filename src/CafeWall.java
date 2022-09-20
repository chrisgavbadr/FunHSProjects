/* CafeWall.java
 *
 * Christian Baduria, Java 2017
 * Ch 3G Project (Cafe Wall), 10/23/17
 *
 * This program creates cafe wall illusion. Rows
 * are printed given their size factor, x and y
 * positions, and # of pairs. Grids are printed given
 * the # of rows and their offset in addition to the
 * row quantities.
 */

import java.awt.*;

public class CafeWall {
    // Sets up the DrawingPanel and calls drawing functions
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(650, 400);
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.GRAY);

        drawRow(20, g, 0, 0, 4);
        drawRow(30, g, 50, 70, 5);
        drawGrid(26, g, 10, 150, 4, 8, 0);
        drawGrid(25, g, 250, 200, 3, 6, 10);
        drawGrid(20, g, 425, 180, 5, 10, 10);
        drawGrid(35, g, 400, 20, 2, 4, 35);
    }

    // Draws a black and white square pair
    public static void drawPair(int size, Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLUE);
        g.drawLine(x, y, x + size - 1, y + size - 1);
        g.drawLine(x + size - 1, y, x, y + size - 1);

        g.setColor(Color.WHITE);
        g.fillRect(x + size, y, size, size);
    }

    // Draws a row with a given # of pairs
    public static void drawRow(int size, Graphics g, int x, int y, int pairs) {
        for (int i = 0; i < pairs; i++) {
            drawPair(size, g, 2 * i * size + x, y);
        }
    }

    // Draws a grid with a given # of rows
    public static void drawGrid(int size, Graphics g, int x, int y, int pairs, int rows, int offset) {
        for (int i = 0; i < rows; i++) {
            drawRow(size, g, i % 2 * offset + x, i * (size + 2) + y, pairs);
        }
    }
}