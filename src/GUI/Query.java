package GUI;

import LBMS.Model;

import java.awt.*;
import javax.swing.*;

public class Query extends JPanel {
    private JButton RedoBtn;
    private JButton UndoBtn;
    private JTextField QueryTxtFld;
    private JButton QueryBtn;
    private JTextArea textArea;
    private JScrollPane scroll;
    private Model model;

    public Query(JFrame frame) {
        //Init model
        model = new Model();

        //construct components
        RedoBtn = new JButton ("Redo");
        UndoBtn = new JButton ("Undo");
        QueryTxtFld = new JTextField (5);
        QueryBtn = new JButton ("Query");
        textArea = new JTextArea (5, 50);
        textArea.setEditable(false);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setSize( 100, 100 );

        //add components
        add (RedoBtn);
        add (UndoBtn);
        add (QueryTxtFld);
        add (QueryBtn);
        add (scroll);

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);


        //set component bounds (only needed by Absolute Positioning)
        RedoBtn.setBounds (225, 500, 100, 25);
        UndoBtn.setBounds (120, 500, 100, 25);
        QueryTxtFld.setBounds (120, 465, 700, 25);
        QueryBtn.setBounds (720, 500, 100, 25);
        scroll.setBounds (120, 80, 700, 375);

        frame.setTitle("Query panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);


        // action listeners
        QueryBtn.addActionListener(e -> {
            textArea.append(">>> " + QueryTxtFld.getText() + "\n");
            String[] response = model.processCommand(QueryTxtFld.getText());
            for (String msg: response) {
                if (msg != null) textArea.append(msg + "\n");
            }
        });
        UndoBtn.addActionListener(e -> {
            // TODO
        });
        RedoBtn.addActionListener(e -> {
            // TODO
        });
    }



}
