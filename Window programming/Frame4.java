import java.awt.*;
import java.awt.event.*;

public class Frame4 implements ActionListener {
    TextField tf;

    Frame4() {
        Frame f1 = new Frame("action lsitener");
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setSize(500, 500);
        Button b1 = new Button("Clicke me");
        b1.setBounds(50, 50, 50, 50);
        b1.addActionListener(this);
        f1.add(b1);
        tf = new TextField();
        tf.setBounds(100, 100, 150, 20);
        f1.add(tf);
    }

    public static void main(String[] args) {
        new Frame4();
    }

    public void actionPerformed(ActionEvent e) {
       tf.setText("null");
    }
}