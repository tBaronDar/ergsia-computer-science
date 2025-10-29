package com.themisdarelis.processtool.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import com.themisdarelis.processtool.model.ProcessInfo;

public class MainPanel extends JPanel {
    public MainPanel() {
        setBorder(new EmptyBorder(24, 32, 24, 32));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Welcome to Process Tool"));
        add(new JButton("Start Process"));

        ArrayList<ProcessInfo> processList = new ArrayList<>();
        //παρε τα προσεσις
        ProcessHandle.allProcesses().forEach(process -> {
            ProcessHandle.Info info = process.info();
            String command = info.command().orElse("unknown");
            String user = info.user().orElse("unknown");
            //καλυτερα οχι τα ρουτ προσεσις, μπορει να γινει ζημια!
            if (!user.equals("root")) {
                processList.add(new ProcessInfo(command, process.pid(), user));
            }
        });

        // δημιουργία μοντέλου πίνακα και πίνακα
        ProcessInfoTableModel tableModel = new ProcessInfoTableModel(processList);
        JTable processTable = new JTable(tableModel);
        processTable.setRowHeight(32);
        processTable.setRowSelectionAllowed(true);
        JScrollPane scrollPane = new JScrollPane(processTable);
        this.add(scrollPane);
    }

}
