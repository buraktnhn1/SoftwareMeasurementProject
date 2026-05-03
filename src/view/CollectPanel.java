package view;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CollectPanel extends JPanel {
    private JPanel inputContainer;
    private Map<String, JTextField> inputFields = new HashMap<>();

    public CollectPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        add(new JLabel("Step 4: Collect Data - Enter Raw Values", SwingConstants.CENTER), BorderLayout.NORTH);

        inputContainer = new JPanel(new GridLayout(0, 2, 10, 20));
        add(new JScrollPane(inputContainer), BorderLayout.CENTER);
    }

    public void generateInputs(String scenario) {
        inputContainer.removeAll();
        inputFields.clear();

        if (scenario.contains("Scenario C")) {
            addInputRow("Lines of Code (100-5000):", "loc");
            addInputRow("Cyclomatic Complexity (1-15):", "cc");
        } else {
            addInputRow("Test Coverage (70-100):", "coverage");
            addInputRow("Defect Density (0-5):", "density");
        }

        revalidate();
        repaint();
    }

    private void addInputRow(String labelText, String key) {
        inputContainer.add(new JLabel(labelText));
        JTextField textField = new JTextField();
        inputContainer.add(textField);
        inputFields.put(key, textField);
    }

    public double getRawValue(String key) {
        String text = inputFields.get(key).getText();
        return Double.parseDouble(text);
    }
}