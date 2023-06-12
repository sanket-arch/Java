import java.awt.*;
import java.awt.event.*;

public class CaseStudy extends Frame {
    public CaseStudy(String title) {
        super(title);
        setSize(800, 800);
        setVisible(true);
        setLayout(new FlowLayout());
        Label l1 = new Label("Text Based LOGO");
        add(l1);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        Frame f1=new Frame();
        f1.setVisible(true);
        f1.setSize(200, 200);
        f1.setLayout(new GridLayout(2, 2));
        Button b1=new Button("title");
        Button b2=new Button("B2");
        f1.add(b1, b2);
        add(f1);
    }

    public static void main(String[] args) {
        new CaseStudy("A Case Study");
    }

}