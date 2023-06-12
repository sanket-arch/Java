import java.awt.*;
import javax.swing.JFrame;

public class DisplayGraphics extends Canvas {

    public void paint(Graphics g) {
        g.drawRect(100, 200, 30, 50);

    }

    public static void main(String[] args) {
        DisplayGraphics m = new DisplayGraphics();
        JFrame f = new JFrame();
        f.add(m);
        f.setSize(400, 400);
        // f.setLayout(null);
        f.setVisible(true);
    }
    
}
