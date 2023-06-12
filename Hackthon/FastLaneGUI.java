import javax.swing.*;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
// import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class FastLaneGUI extends JFrame implements ActionListener {
    private JTextField sourceField;
    private JTextField destinationField;
    private JTextArea resultTextArea;
    private JPanel gridPanel;

    private Map<String, Map<String, Integer>> graph;
    private Map<String, Integer> vertexToIndex;

    public FastLaneGUI() {
        graph = new HashMap<>();
        vertexToIndex = new HashMap<>();

        setTitle("FastLane - Emergency Services");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel sourceLabel = new JLabel("Source:");
        sourceField = new JTextField();
        JLabel destinationLabel = new JLabel("Destination:");
        destinationField = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        inputPanel.add(sourceLabel);
        inputPanel.add(sourceField);
        inputPanel.add(destinationLabel);
        inputPanel.add(destinationField);
        inputPanel.add(calculateButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(5, 5));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);
        mainPanel.add(gridPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        String source = sourceField.getText();
        String destination = destinationField.getText();

        if (!vertexToIndex.containsKey(source) || !vertexToIndex.containsKey(destination)) {
            JOptionPane.showMessageDialog(this, "Invalid source or destination. Please try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, Integer> shortestPath = calculateShortestPath(source, destination);
        if (shortestPath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No path found from source to destination.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = buildResultString(shortestPath);
        resultTextArea.setText(result);

        clearGrid();
        drawShortestPath(shortestPath);
    }

    private Map<String, Integer> calculateShortestPath(String source, String destination) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();

        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        distances.put(source, 0);
        queue.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);

            if (current.equals(destination)) {
                break;
            }

            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                String next = neighbor.getKey();
                int distance = neighbor.getValue();
                int totalDistance = distances.get(current) + distance;

                if (!visited.contains(next) && (!distances.containsKey(next) || totalDistance < distances.get(next))) {
                    distances.put(next, totalDistance);
                    previous.put(next, current);
                    queue.add(next);
                }
            }
        }

        Map<String, Integer> shortestPath = new LinkedHashMap<>();
        String current = destination;
        while (previous.containsKey(current)) {
            shortestPath.put(current, distances.get(current));
            current = previous.get(current);
        }
        shortestPath.put(source, distances.get(source));

        return shortestPath;
    }

    private String buildResultString(Map<String, Integer> shortestPath) {
        StringBuilder sb = new StringBuilder();
        sb.append("Shortest Path:\n");
        sb.append("--------------\n");

        List<String> path = new ArrayList<>(shortestPath.keySet());
        Collections.reverse(path);

        for (String vertex : path) {
            int distance = shortestPath.get(vertex);
            sb.append(vertex).append(" (").append(distance).append(" km)\n");
        }

        return sb.toString();
    }

    private void clearGrid() {
        gridPanel.removeAll();
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void drawShortestPath(Map<String, Integer> shortestPath) {
        List<String> path = new ArrayList<>(shortestPath.keySet());

        for (int i = 0; i < path.size(); i++) {
            String vertex = path.get(i);
            int row = vertexToIndex.get(vertex) / 5;
            int col = vertexToIndex.get(vertex) % 5;

            JPanel cell = new JPanel();
            cell.setBackground(Color.YELLOW);
            gridPanel.add(cell);

            if (i < path.size() - 1) {
                String nextVertex = path.get(i + 1);
                int nextRow = vertexToIndex.get(nextVertex) / 5;
                int nextCol = vertexToIndex.get(nextVertex) % 5;

                if (nextRow > row) {
                    drawHorizontalArrow(cell);
                } else if (nextRow < row) {
                    drawHorizontalArrow(cell, SwingConstants.BOTTOM);
                } else if (nextCol > col) {
                    drawVerticalArrow(cell);
                } else if (nextCol < col) {
                    drawVerticalArrow(cell, SwingConstants.RIGHT);
                }
            }
        }
    }

    private void drawHorizontalArrow(JPanel panel, int direction) {
        panel.setLayout(new BorderLayout());
        panel.add(new ArrowLabel(SwingConstants.HORIZONTAL, direction), BorderLayout.CENTER);
    }

    private void drawHorizontalArrow(JPanel panel) {
        drawHorizontalArrow(panel, SwingConstants.TOP);
    }

    private void drawVerticalArrow(JPanel panel, int direction) {
        panel.setLayout(new BorderLayout());
        panel.add(new ArrowLabel(SwingConstants.VERTICAL, direction), BorderLayout.CENTER);
    }

    private void drawVerticalArrow(JPanel panel) {
        drawVerticalArrow(panel, SwingConstants.LEFT);
    }

    private class ArrowLabel extends JLabel {
        private int orientation;
        private int direction;

        public ArrowLabel(int orientation, int direction) {
            this.orientation = orientation;
            this.direction = direction;
            setOpaque(false);
            setPreferredSize(new Dimension(20, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

            if (orientation == SwingConstants.HORIZONTAL) {
                y1 = getHeight() / 2;
                y2 = y1;

                if (direction == SwingConstants.TOP) {
                    x1 = getWidth();
                }
                if (direction == SwingConstants.BOTTOM) {
                    x2 = getWidth();
                }
            } else if (orientation == SwingConstants.VERTICAL) {
                x1 = getWidth() / 2;
                x2 = x1;

                if (direction == SwingConstants.LEFT) {
                    y1 = getHeight();
                }
                if (direction == SwingConstants.RIGHT) {
                    y2 = getHeight();
                }
            }

            g2d.setStroke(new BasicStroke(3));
            g2d.setColor(Color.RED);
            g2d.drawLine(x1, y1, x2, y2);

            int[] xPoints = {x2 - 5, x2 + 5, x2};
            int[] yPoints = {y2 - 5, y2 - 5, y2 + 5};

            g2d.fillPolygon(xPoints, yPoints, 3);

            g2d.dispose();
        }
    }

    public void addVertex(String vertex) {
        vertexToIndex.put(vertex, vertexToIndex.size());
        graph.put(vertex, new HashMap<>());
    }

    public void addEdge(String source, String destination, int distance) {
        graph.get(source).put(destination, distance);
        graph.get(destination).put(source, distance);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FastLaneGUI fastLane = new FastLaneGUI();
            fastLane.addVertex("A");
            fastLane.addVertex("B");
            fastLane.addVertex("C");
            fastLane.addVertex("D");
            fastLane.addVertex("E");
            fastLane.addEdge("A", "B", 5);
            fastLane.addEdge("A", "D", 3);
            fastLane.addEdge("B", "C", 2);
            fastLane.addEdge("B", "D", 2);
            fastLane.addEdge("C", "E", 4);
            fastLane.addEdge("D", "E", 1);
            fastLane.setVisible(true);
        });
    }
}
