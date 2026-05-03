package view;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JTextField txtUsername = new JTextField(20);
    private JTextField txtSchool = new JTextField(20);
    private JTextField txtSession = new JTextField(20);

    public ProfilePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Font("Arial", Font.PLAIN, 10).getStyle() == 0 ? new Insets(10, 10, 10, 10) : new Insets(10, 10, 10, 10);
        gbc.gridx = 0; gbc.gridy = 0;

        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("School:"), gbc);
        gbc.gridx = 1; add(txtSchool, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Session Name:"), gbc);
        gbc.gridx = 1; add(txtSession, gbc);
    }

    public boolean isDataValid() {
        if (txtUsername.getText().trim().isEmpty() ||
                txtSchool.getText().trim().isEmpty() ||
                txtSession.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
}