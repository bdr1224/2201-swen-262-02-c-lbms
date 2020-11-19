package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel userLabel = new JLabel("Username");
    private JLabel titleLabel = new JLabel("LBMS Login");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Sign up");


    public Login() {
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        setPreferredSize (new Dimension (360, 400));
        setLayout(null);

        add(titleLabel);
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(loginButton);
        add(resetButton);

        titleLabel.setBounds(120, 50, 200, 30);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);

    }
    

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Login());
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

}
    