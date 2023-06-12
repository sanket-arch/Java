import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2;
    JRadioButton male, female;
    JComboBox<String> day, month, year;
    JTextArea ta1, outputdata;
    JCheckBox terms;
    JButton submit;
    JLabel msg;

    MyFrame() {
        setTitle("Registration form");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Name");
        l1.setBounds(20, 50, 100, 20);
        c.add(l1);
        t1 = new JTextField();
        t1.setBounds(130, 50, 100, 20);
        c.add(t1);

        l2 = new JLabel("Mobile");
        l2.setBounds(20, 100, 100, 20);
        c.add(l2);
        t2 = new JTextField();
        t2.setBounds(130, 100, 100, 20);
        c.add(t2);

        l3 = new JLabel("Gender");
        l3.setBounds(20, 150, 100, 20);
        c.add(l3);
        male = new JRadioButton("Male");
        male.setSelected(true);
        female = new JRadioButton("Female");

        male.setBounds(130, 150, 80, 20);
        female.setBounds(220, 150, 80, 20);
        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);
        c.add(male);
        c.add(female);

        l4 = new JLabel("Birth");
        l4.setBounds(20, 200, 100, 20);
        c.add(l4);

        String[] days = { "1", "2", "3", "4", "5", "6", "7" };
        String[] months = { "jan", "feb", "mar", "apr", "may", "june" };
        String[] years = { "1999", "2000", "2001", "2002" };

        day = new JComboBox<>(days);
        month = new JComboBox<>(months);
        year = new JComboBox<>(years);

        day.setBounds(130, 200, 50, 20);
        month.setBounds(200, 200, 50, 20);
        year.setBounds(270, 200, 50, 20);
        c.add(day);
        c.add(month);
        c.add(year);

        l5 = new JLabel("Address");
        l5.setBounds(20, 240, 100, 20);
        c.add(l5);

        ta1 = new JTextArea();
        ta1.setBounds(130, 240, 200, 50);
        ta1.setBackground(Color.GRAY);
        c.add(ta1);

        terms = new JCheckBox("Accept terms and conditon");
        terms.setBounds(20, 320, 300, 50);
        c.add(terms);

        submit = new JButton("Submit");
        submit.setBounds(130, 390, 80, 20);
        submit.addActionListener(this);
        c.add(submit);

        outputdata = new JTextArea();
        outputdata.setBounds(400, 50, 300, 400);
        c.add(outputdata);

        msg = new JLabel("");
        msg.setBounds(20, 430, 200, 20);
        c.add(msg);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            if (terms.isSelected()) {
                msg.setText("Registraction Succesfully");
                String name = t1.getText();
                String Mobile = t2.getText();
                String gender = "Male";
                if (female.isSelected()) {
                    gender = "female";
                }
                String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
                String address = ta1.getText();

                outputdata.setText(name + "\n" + Mobile + "\n" + gender + "\n" + dob + "\n" + address);
            } else {
                msg.setText("Select Terms and conditions");
            }
        }

    }
}

public class RegistrationFrom {
    public static void main(String[] args) {
        new MyFrame();
    }
}
