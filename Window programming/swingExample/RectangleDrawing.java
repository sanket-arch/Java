import javax.swing.*;
import java.awt.*;

public class RectangleDrawing extends JFrame {

    public RectangleDrawing() {
        setTitle("Rectangle Drawing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Set the color of the rectangle
        g.setColor(Color.RED);

        // Draw a rectangle with the specified dimensions
        int x = 50;
        int y = 50;
        int width = 200;
        int height = 100;
        g.drawRect(x, y, width, height);
    }

    public static void main(String[] args) {
        new RectangleDrawing().setVisible(true);
        // SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
                
        //     }
        // });
    }
}
