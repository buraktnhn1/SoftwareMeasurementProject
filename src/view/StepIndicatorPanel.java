package view;

import javax.swing.*;
import java.awt.*;

public class StepIndicatorPanel extends JPanel {
    private JLabel[] labels;
    private String[] steps = {"Profile", "Define", "Plan", "Collect", "Analyse"};

    public StepIndicatorPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15));
        labels = new JLabel[steps.length];
        for (int i = 0; i < steps.length; i++) {
            labels[i] = new JLabel(steps[i]);
            labels[i].setForeground(Color.LIGHT_GRAY);
            add(labels[i]);
            if (i < steps.length - 1) add(new JLabel("→"));
        }
        setCurrentStep(0);
    }

    public void setCurrentStep(int index) {
        for (int i = 0; i < labels.length; i++) {
            if (i < index) {
                labels[i].setText(steps[i] + " ✓");
                labels[i].setForeground(new Color(40, 167, 69)); // Green
            } else if (i == index) {
                labels[i].setForeground(Color.BLUE);
                labels[i].setFont(new Font("Arial", Font.BOLD, 14));
            } else {
                labels[i].setForeground(Color.LIGHT_GRAY);
                labels[i].setFont(new Font("Arial", Font.PLAIN, 12));
            }
        }
    }
}