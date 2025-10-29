package com.themisdarelis.processtool.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    public MainFrame() {
        JPanel mainPanel = new MainPanel();
        super("Process Tool");
        setResizable(true);
        setSize(720, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



        setContentPane(mainPanel);
    }
}
