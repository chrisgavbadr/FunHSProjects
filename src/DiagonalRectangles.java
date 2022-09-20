import java.awt.*;

public class DiagonalRectangles {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(150, 140);
        Graphics g = panel.getGraphics();

        for (int i = 1; i <= 5; i++) {
            g.drawRect(20 * i - 9, -20 * i + 118, 20, 20);
        }
    }
}