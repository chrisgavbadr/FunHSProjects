import java.awt.*;

public class JavaBookFigure {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(1000, 1000);
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.WHITE);

        drawFigure(10, panel, 20, g, 20, 35);
        drawFigure(6, panel, 10, g, 150, 70);
        drawFigure(20, panel, 10, g, 300, 10);
    }

    public static void drawFigure(int size, DrawingPanel panel, int stairs, Graphics g, int x, int y) {
        Color brown = new Color(191, 118, 73);

        g.setColor(Color.CYAN);
        g.fillRect(x, y, 10 * size, 10 * size);

        g.setColor(Color.WHITE);
        g.drawString("BJP", x + 5 * size, y + 3 * size);

        g.setColor(brown);
        for (int i = 0; i < stairs; i++) {
            g.fillRect(x, i * size / (stairs / 10) + y, i * size / (stairs / 10) - size / (stairs / 10) + size, size / (stairs / 10) - 1);
            panel.sleep(i * 50);
        }
    }
}