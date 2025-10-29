package com.themisdarelis.processtool.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;



public class MainFrame extends JFrame {
    public MainFrame() {
        super("Process Tool");
        JPanel mainPanel = new MainPanel();
        setMinimumSize(new Dimension(800, 600));
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);



        setContentPane(mainPanel);
    }
}
