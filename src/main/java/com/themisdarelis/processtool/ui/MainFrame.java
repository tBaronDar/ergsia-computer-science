package com.themisdarelis.processtool.ui;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
    public MainFrame() {
        super("Process Tool");
        setResizable(true);
        setSize(720, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


        this.add(new MainPanel());
    }
}
