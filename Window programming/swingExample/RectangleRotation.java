import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleRotation extends JFrame {
    private RectanglePanel rectanglePanel;

    public RectangleRotation() {
        setTitle("Rectangle Rotation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the rectangle
        rectanglePanel = new RectanglePanel();
        add(rectanglePanel, BorderLayout.CENTER);

        // Create a button to rotate the rectangle
        JButton rotateButton = new JButton("Rotate");
        rotateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rectanglePanel.rotateRectangle(15);
            }
        });
        add(rotateButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RectangleRotation();
            }
        });
    }
}

class RectanglePanel extends JPanel {
    private double angle = 0;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        int rectWidth = 100;
        int rectHeight = 50;

        // Calculate the rotation point
        int rectCenterX = centerX - rectWidth / 2;
        int rectCenterY = centerY - rectHeight / 2;

        // Translate and rotate the graphics context
        g2d.translate(rectCenterX, rectCenterY);
        g2d.rotate(Math.toRadians(angle));

        // Draw the rectangle
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, rectWidth, rectHeight);

        // Reset the graphics context transformation
        g2d.rotate(-Math.toRadians(angle));
        g2d.translate(-rectCenterX, -rectCenterY);
    }

    public void rotateRectangle(double degrees) {
        angle += degrees;
        repaint();
    }
}
