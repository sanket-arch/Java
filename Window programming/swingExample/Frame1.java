import javax.swing.*;
import java.awt.event.*;;

public class Frame1 extends JFrame implements ActionListener {
    JTextField tf1, tf2, tf3;
    JButton add, sub;
    JTextField jt;
    JTable jtable;
    String[] query = { "Display all Author", "Display specific author", "specific title", "write your own query" };;
    JComboBox<String> cb = new JComboBox<>(query);

    Frame1(String title) {
        super(title);
        setVisible(true);
        setLayout(null);
        setSize(800, 800);

        cb.setBounds(200, 200, 300, 100);
        cb.addActionListener(this);
        add(cb);

        jt = new JTextField();
        jt.addActionListener(this);
        jt.setBounds(200, 400, 100, 100);
        jt.setVisible(false);
        add(jt);

        String data[][] = { { "101", "Amit", "670000" },
                { "102", "Jai", "780000" },
                { "101", "Sachin", "700000" } };
        String column[] = { "ID", "NAME", "SALARY" };
        jtable = new JTable(data, column);
        setBounds(200, 550, 400, 400);
        add(jt);

        JFrame f = new JFrame();
        JOptionPane.showMessageDialog(f, "You have added successfully");
        String name = JOptionPane.showInputDialog(f, "Enter your name");
        System.out.println(name);
    }
    

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cb) {
            String querytype = cb.getItemAt(cb.getSelectedIndex());
            System.out.println(querytype);
            if (querytype == "Display specific author") {
                jt.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        new Frame1("Swing Demo");
    }

}
