import java.awt.*;
import java.awt.event.*;

public class Frame1 extends Frame {
    Button b1;
    TextField tf;

    Frame1(String title) {
        super(title);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setVisible(true);
        setSize(400, 400);
        setFont(new Font("Arial", Font.ITALIC, 20));
        setLayout(new FlowLayout());
        // event registration

        b1 = new Button("practice");
        b1.setSize(20, 400);
        b1.setVisible(true);
        add(b1);
        Scrollbar sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 300);

        add(sb);
        tf = new TextField("", 20);
        tf.setSize(200, 100);
        add(tf);

        addWindowListener(new WindowAdapter() {// start of AIC
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        }// end of AIC
        );
    }

    public static void main(String[] args) {
        new Frame1("practice");
    }
}
