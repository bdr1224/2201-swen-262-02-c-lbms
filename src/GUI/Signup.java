package GUI;

import LBMS.Model;

import javax.swing.*;
import java.awt.*;

public class Signup extends JPanel{
    private JLabel FirstNameLbl;
    private JLabel LastNameLbl;
    private JLabel AddressLbl;
    private JLabel PhoneNoLbl;
    private JLabel EmailLbl;
    private JLabel PasswordLbl;
    private JLabel titleLabel;
    private JPasswordField passwordField;

    private JTextField FirstNameField;
    private JTextField LastNameField;
    private JTextField AddressField;
    private JTextField PhoneNoField;
    private JTextField EmailField;

    private JButton SignUpButton;

    private Model model;

    public Signup(JFrame frame, Model model){
        // Init model
        this.model = model;

        //construct components

        // Labels
        FirstNameLbl = new JLabel("First name");
        LastNameLbl = new JLabel("Last name");
        AddressLbl = new JLabel("Address");
        PhoneNoLbl = new JLabel("Phone number");
        EmailLbl = new JLabel("Email Address");
        PasswordLbl = new JLabel("Password");
        titleLabel = new JLabel("Register visitor");

        // Text fields
        FirstNameField = new JTextField();
        LastNameField = new JTextField();
        AddressField = new JTextField();
        PhoneNoField = new JTextField();
        EmailField = new JTextField();
        passwordField = new JPasswordField();

        SignUpButton = new JButton("Sign up");
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        setPreferredSize (new Dimension (360, 680));
        setLayout(null);

        // Add labels
        add(FirstNameLbl);
        add(LastNameLbl);
        add(AddressLbl);
        add(PhoneNoLbl);
        add(EmailLbl);
        add(PasswordLbl);
        add(titleLabel);

        // Add fields
        add(FirstNameField);
        add(LastNameField);
        add(AddressField);
        add(PhoneNoField);
        add(EmailField);
        add(passwordField);

        add(SignUpButton);


        titleLabel.setBounds(100, 50, 300, 40);

        FirstNameLbl.setBounds(50, 150, 100, 30);
        LastNameLbl.setBounds(50, 220, 100, 30);
        AddressLbl.setBounds(50, 290, 100, 30);
        PhoneNoLbl.setBounds(50, 360, 100, 30);
        EmailLbl.setBounds(50, 430, 100, 30);
        PasswordLbl.setBounds(50, 500, 100, 30);

        FirstNameField.setBounds(150, 150, 150, 30);
        LastNameField.setBounds(150, 220, 150, 30);
        AddressField.setBounds(150, 290, 150, 30);
        PhoneNoField.setBounds(150, 360, 150, 30);
        EmailField.setBounds(150, 430, 150, 30);
        passwordField.setBounds(150, 500, 150, 30);

        SignUpButton.setBounds(120, 580, 100, 30);

        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


        // action listeners
        SignUpButton.addActionListener(e -> {
            frame.remove(this);
            JPanel loginPanel = new Login(frame, model);
        });

    }


}
