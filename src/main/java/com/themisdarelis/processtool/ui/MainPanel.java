package com.themisdarelis.processtool.ui;

import java.util.stream.Stream;

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
        Stream<ProcessHandle> processes = ProcessHandle.allProcesses();

        processes.forEach(process -> {
            ProcessHandle.Info info = process.info();
            System.out.printf("PID: %d, Command: %s, User: %s%n",
                    process.pid(),
                    info.command().orElse("unknown"),
                    info.user().orElse("unknown"));
                    string1 = info.command().orElse("unknown") + " (PID: " + process.pid() + ")\n";
        });

        processdata.setText(string1);
    }

}
