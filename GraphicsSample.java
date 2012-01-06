import java.awt.*;

class GraphicsSample
{
    public static void main(String args[]) {
        GraphicsDraw paper = new GraphicsDraw();

        paper.setSize(640, 640);
        paper.setTitle("Fractal");
        paper.setVisible( true );
    }
}

class GraphicsDraw extends Frame
{
    public void paint(Graphics g) {
        drawTree (g, 1, 320, 320, 0);
    }

    private void drawTree (Graphics g, int n, int x, int y, float angle) {
        g.setColor(Color.red);
        g.fillOval(40, 80, 60, 60);
        g.setColor(Color.blue);
        g.fillRect(110, 40, 60, 60);
        g.setColor(Color.black);
        g.drawLine(0, 20, 100, 130);
        g.drawLine(200, 20, 10, 130);
    }
}
