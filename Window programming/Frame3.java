import java.awt.*;

public class Frame3 {
    Label logo;

    Frame3() {
        Frame f = new Frame("case Study");
        Panel left = new Panel();
        Panel right = new Panel();
        left.setBackground(Color.BLUE);
        right.setBackground(Color.black);
        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        logo = new Label("text based logo");
        logo.setBounds(10,10,600,50);
        f.add(logo);
        Panel p=new Panel(new GridLayout(1, 2));
        p.setBounds(50, 50, 600, 500);
        // p.setBackground(Color.CYAN);
        left.add(b1);
        right.add(b2);
        p.add(left);
        p.add(right);
        f.add(p);
        f.setSize(800, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Frame3();
    }
}
