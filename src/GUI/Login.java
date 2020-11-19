package GUI;

import LBMS.Model;

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
    private JButton SignUpButton = new JButton("Sign up");

    private Model model;


    public Login(JFrame frame, Model model) {
        this.model = model;

        titleLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        setPreferredSize (new Dimension (360, 400));
        setLayout(null);

        add(titleLabel);
        add(userLabel);
        add(passwordLabel);
        add(userTextField);
        add(passwordField);
        add(loginButton);
        add(SignUpButton);

        titleLabel.setBounds(120, 50, 200, 30);
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        SignUpButton.setBounds(200, 300, 100, 30);

        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        // action listeners
        loginButton.addActionListener(e -> {
            if(!userTextField.getText().equals("") && !passwordField.getText().equals("")) {
                String[] response = model.processCommand("visit," + userTextField.getText() + "," + passwordField.getText() + ";");
                frame.remove(this);
                JPanel queryPanel = new Query(frame, model);
            } else System.out.println("Enter acc info");
        });
        SignUpButton.addActionListener(e -> {
            if(!userTextField.getText().equals("") && !passwordField.getText().equals("")) {
                String[] response = model.processCommand("register," + userTextField.getText() + "," + passwordField.getText() + ",test,test;");
                frame.remove(this);
                JPanel queryPanel = new Query(frame, model);
            } else System.out.println("Enter acc info");
        });

    }
    


}
    