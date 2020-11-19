package GUI;

import java.awt.*;
import javax.swing.*;

public class Query extends JPanel {
    private JButton RedoBtn;
    private JButton UndoBtn;
    private JTextField QueryTxtFld;
    private JButton QueryBtn;
    private JTextArea textArea;

    public Query(JFrame frame) {
        //construct components
        RedoBtn = new JButton ("Redo");
        UndoBtn = new JButton ("Undo");
        QueryTxtFld = new JTextField (5);
        QueryBtn = new JButton ("Query");
        textArea = new JTextArea (5, 5);
        textArea.setEditable(false);

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //add components
        add (RedoBtn);
        add (UndoBtn);
        add (QueryTxtFld);
        add (QueryBtn);
        add (textArea);

        //set component bounds (only needed by Absolute Positioning)
        RedoBtn.setBounds (225, 500, 100, 25);
        UndoBtn.setBounds (120, 500, 100, 25);
        QueryTxtFld.setBounds (120, 465, 700, 25);
        QueryBtn.setBounds (720, 500, 100, 25);
        textArea.setBounds (120, 80, 700, 375);

        frame.setTitle("Query panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }



}
