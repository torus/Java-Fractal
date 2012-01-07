import java.awt.*;
import java.awt.image.*;

class GraphicsSample
{
    public static void main(String args[]) {
        GraphicsDraw paper = new GraphicsDraw();

        paper.setSize(640, 480);
        paper.setTitle("Fractal");
        paper.setVisible( true );
    }
}

class GraphicsDraw extends Frame
{
    public void paint(Graphics g) {
        BufferedImage buf = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics bufg = buf.getGraphics();
        bufg.setColor(Color.white);
        bufg.fillRect(0, 0, 640, 480);

        drawTree(bufg, 1, 100, 240, 0, 1);
        g.drawImage(buf, 0, 0, Color.black, null);
    }

    private void drawTree(Graphics g, int n, int x, int y, double angle, int sign) {
        if (n > 31) return;

        int r = 200 / n;
        int c = (n % 15) * 16;

        g.setColor(new Color(255, 255 - c, c));
        g.fillOval(x - r / 2, y - r / 2, r, r);

        int r2 = (r + 200 / (n + 1)) / 2;

        drawTree(g, n + 1,
                 x + (int)(Math.cos(angle) * r2), y + (int)(Math.sin(angle) * r2),
                 angle + Math.PI * 0.1 * sign, sign);
        if (Math.random() < 0.2) {
            double a2 = angle - Math.PI * 0.5 * sign;
            drawTree(g, n + 1,
                     x + (int)(Math.cos(a2) * r2),
                     y + (int)(Math.sin(a2) * r2), a2, -sign);
        }
    }
}
