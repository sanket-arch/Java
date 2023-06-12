import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberConverter {
    private JLabel decimalLabel, hexLabel, binaryLabel;
    private JTextField decimalField, hexField, binaryField;

    public NumberConverter() {
        decimalLabel = new JLabel("Enter Decimal value:");
        hexLabel = new JLabel("Enter Hex value:");
        binaryLabel = new JLabel("Enter Binary value:");
        decimalField = new JTextField(15);
        hexField = new JTextField(15);
        binaryField = new JTextField(15);

        JFrame frame = new JFrame("Convert Numbers");
        frame.setLayout(new GridLayout(3, 2));
        frame.add(decimalLabel);
        frame.add(decimalField);
        frame.add(hexLabel);
        frame.add(hexField);
        frame.add(binaryLabel);
        frame.add(binaryField);
        decimalField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String decimalStr = decimalField.getText();
                int decimal = Integer.parseInt(decimalStr);
                String hex = Integer.toHexString(decimal);
                String binary = Integer.toBinaryString(decimal);
                hexField.setText(hex);
                binaryField.setText(binary);
            }
        });
        hexField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hex = hexField.getText();
                int decimal = Integer.parseInt(hex, 16);
                String binary = Integer.toBinaryString(decimal);
                decimalField.setText(Integer.toString(decimal));
                binaryField.setText(binary);
            }
        });
        binaryField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String binary = binaryField.getText();
                int decimal = Integer.parseInt(binary, 2);
                String hex = Integer.toHexString(decimal);
                decimalField.setText(Integer.toString(decimal));
                hexField.setText(hex);
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NumberConverter();
    }
}