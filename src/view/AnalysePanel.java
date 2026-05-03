package view;

import javax.swing.*;
import java.awt.*;

public class AnalysePanel extends JPanel {
    private JTextArea resultArea = new JTextArea();

    public AnalysePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("Step 5: Measurement Analysis & Reporting", SwingConstants.CENTER), BorderLayout.NORTH);

        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }

    public void calculateResults(double loc, double cc) {
        double locScore = (loc / 5000) * 100;
        double ccScore = (1 - (cc / 15)) * 100;
        double total = (locScore * 0.4) + (ccScore * 0.6);

        StringBuilder sb = new StringBuilder();
        sb.append("--- QUALITY ANALYSIS REPORT ---\n\n");
        sb.append(String.format("Lines of Code Score: %.2f / 100\n", locScore));
        sb.append(String.format("Complexity Score:    %.2f / 100\n", ccScore));
        sb.append("-------------------------------\n");
        sb.append(String.format("FINAL QUALITY SCORE: %.2f / 100\n", total));

        if(total > 70) sb.append("\nStatus: EXCELLENT");
        else if(total > 50) sb.append("\nStatus: ACCEPTABLE");
        else sb.append("\nStatus: NEEDS IMPROVEMENT");

        resultArea.setText(sb.toString());
    }
}