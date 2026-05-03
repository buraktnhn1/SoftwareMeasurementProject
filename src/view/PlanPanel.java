package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlanPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public PlanPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] columns = {"Metric Name", "Coefficient", "Direction", "Range", "Unit"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        add(new JLabel("Step 3: Measurement Plan - Selected Metrics", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void loadMetrics(String scenario) {
        tableModel.setRowCount(0);
        if (scenario.contains("Scenario C")) {
            tableModel.addRow(new Object[]{"Lines of Code", "3", "Lower↓", "100-5000", "LOC"});
            tableModel.addRow(new Object[]{"Cyclomatic Complexity", "5", "Lower↓", "1-15", "CC"});
        } else {
            tableModel.addRow(new Object[]{"Test Coverage", "4", "Higher↑", "70-100", "%"});
            tableModel.addRow(new Object[]{"Defect Density", "2", "Lower↓", "0-5", "Defects/KLOC"});
        }
    }
}