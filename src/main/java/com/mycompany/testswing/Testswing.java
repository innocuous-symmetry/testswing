/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.testswing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mikayladobson
 */
public class Testswing implements ActionListener {
    private static int numClicks = 0;
    private final JFrame frame;
    
    private final JButton button;
    private final JButton AButton;
    private final JButton BButton;
    private final JButton CButton;
    private final JButton clearButton;
    
    private final JPanel panel;
    private final JLabel label;
    
    public Testswing() {
        frame = new JFrame();
        
        button = new JButton("Click to do stuff");
        label = new JLabel("Calculator does stuff! " + this.numClicks);
        
        AButton = new JButton("Add A");
        BButton = new JButton("Add B");
        CButton = new JButton("Add C");
        clearButton = new JButton("Clear");
        
        JButton[] allButtons = { button, AButton, BButton, CButton, clearButton };
        for (JButton each : allButtons) {
            each.addActionListener(this);
        }
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        
        panel.add(AButton);
        panel.add(BButton);
        panel.add(CButton);
        panel.add(clearButton);
               
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Testswing();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == button) {
            this.numClicks++;
            label.setText("Calculator does stuff! " + this.numClicks);
        } else if (e.getSource() == AButton) {
            String newText = label.getText() + "A";
            label.setText(newText);
        } else if (e.getSource() == BButton) {
            label.setText(label.getText() + "B");
        } else if (e.getSource() == CButton) {
            label.setText(label.getText() + "C");
        } else if (e.getSource() == clearButton) {
            this.numClicks = 0;
            label.setText("0");
        }
    }
}
