import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ProgressCardGUI extends JFrame implements ActionListener {
    private JTextField childNameField;
    private JComboBox<String> domainComboBox;
    private JSpinner scoreSpinner;
    private JTextArea progressTextArea;

    private Map<String, Map<String, Integer>> progressData;

    public ProgressCardGUI() {
        progressData = new HashMap<>();

        setTitle("Progress Card - Parent's Guide");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel childNameLabel = new JLabel("Child's Name:");
        childNameField = new JTextField();
        JLabel domainLabel = new JLabel("Domain:");
        domainComboBox = new JComboBox<>(new String[]{"Cognitive", "Psychomotor", "Affective"});
        JLabel scoreLabel = new JLabel("Score (0-10):");
        scoreSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(this);

        inputPanel.add(childNameLabel);
        inputPanel.add(childNameField);
        inputPanel.add(domainLabel);
        inputPanel.add(domainComboBox);
        inputPanel.add(scoreLabel);
        inputPanel.add(scoreSpinner);
        inputPanel.add(enterButton);

        progressTextArea = new JTextArea();
        progressTextArea.setEditable(false);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(progressTextArea), BorderLayout.CENTER);

        add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String childName = childNameField.getText();
        String domain = (String) domainComboBox.getSelectedItem();
        int score = (int) scoreSpinner.getValue();

        if (!isValidDomain(domain) || !isValidScore(score)) {
            JOptionPane.showMessageDialog(this, "Invalid domain or score. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        progressData.computeIfAbsent(childName, k -> new HashMap<>()).put(domain, score);
        updateProgressText();
        clearInputFields();
    }

    private boolean isValidDomain(String domain) {
        return domain.equalsIgnoreCase("Cognitive")
                || domain.equalsIgnoreCase("Psychomotor")
                || domain.equalsIgnoreCase("Affective");
    }

    private boolean isValidScore(int score) {
        return score >= 0 && score <= 10;
    }

    private void updateProgressText() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> entry : progressData.entrySet()) {
            String childName = entry.getKey();
            Map<String, Integer> childProgress = entry.getValue();

            sb.append("Child Name: ").append(childName).append("\n");

            for (Map.Entry<String, Integer> domainEntry : childProgress.entrySet()) {
                String domain = domainEntry.getKey();
                int score = domainEntry.getValue();

                sb.append("- Domain: ").append(domain).append("\n");
                sb.append("  Score: ").append(score).append("\n");
            }
            sb.append("\n");
        }
        progressTextArea.setText(sb.toString());
    }

    private void clearInputFields() {
        childNameField.setText("");
        domainComboBox.setSelectedIndex(0);
        scoreSpinner.setValue(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgressCardGUI progressCard = new ProgressCardGUI();
            progressCard.setVisible(true);
        });
    }
}
