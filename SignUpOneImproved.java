package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class SignUpOneImproved extends JFrame {

    JTextField nameTextField;
    JComboBox<String> genderComboBox;
    JTextArea addressTextArea;
    JComboBox<String> maritalStatusComboBox;

    SignUpOneImproved() {
        setTitle("Sign Up - Personal Details");

        setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // ... Add form components with GridBagConstraints ...

        // Add content panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ... Rest of your code ...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpOneImproved());
    }
}

