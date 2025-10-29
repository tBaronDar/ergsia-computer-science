package com.themisdarelis.processtool.ui;

import javax.swing.*;

public class MainPanel extends JPanel {
        String string1 = "";

    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Welcome to Process Tool"));
        this.add(new JButton("Start Process"));


        var processdata = new JTextArea(20, 50);
        processdata.setEditable(false);
        this.add(processdata);
        // Stream all processes
        StringBuilder processInfo = new StringBuilder();

        ProcessHandle.allProcesses().forEach(process -> {
            ProcessHandle.Info info = process.info();
            String command = info.command().orElse("unknown");
            String user = info.user().orElse("unknown");
            processInfo.append(String.format("Command: %s | PID: %d | User: %s%n",
                command, process.pid(), user));
        });

        processdata.setText(processInfo.toString());
    }

}
