package com.themisdarelis.processtool.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    public MainFrame() {
        JPanel mainPanel = new MainPanel();
        super("Process Tool");
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);



        setContentPane(mainPanel);
    }
}
