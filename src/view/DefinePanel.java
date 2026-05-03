package view;

import javax.swing.*;
import java.awt.*;

public class DefinePanel extends JPanel {
    private JRadioButton rbProduct = new JRadioButton("Product Quality");
    private JRadioButton rbProcess = new JRadioButton("Process Quality");
    private JRadioButton rbHealth = new JRadioButton("Health");
    private JRadioButton rbEducation = new JRadioButton("Education");
    private JComboBox<String> comboScenarios = new JComboBox<>();

    public DefinePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.setBorder(BorderFactory.createTitledBorder("1. Select Quality Type"));
        ButtonGroup group1 = new ButtonGroup();
        group1.add(rbProduct); group1.add(rbProcess);
        p1.add(rbProduct); p1.add(rbProcess);
        rbProduct.setSelected(true);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.setBorder(BorderFactory.createTitledBorder("2. Select Mode"));
        ButtonGroup group2 = new ButtonGroup();
        group2.add(rbHealth); group2.add(rbEducation);
        p2.add(rbHealth); p2.add(rbEducation);
        rbEducation.setSelected(true);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.setBorder(BorderFactory.createTitledBorder("3. Select Scenario"));
        comboScenarios.addItem("Scenario C - Performance");
        comboScenarios.addItem("Scenario D - Reliability");
        p3.add(new JLabel("Scenarios: "));
        p3.add(comboScenarios);

        add(p1); add(Box.createRigidArea(new Dimension(0, 20)));
        add(p2); add(Box.createRigidArea(new Dimension(0, 20)));
        add(p3);
    }

    public String getSelectedScenario() {
        return (String) comboScenarios.getSelectedItem();
    }
}