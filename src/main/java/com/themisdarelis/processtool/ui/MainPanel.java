package com.themisdarelis.processtool.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.Font;
import java.util.ArrayList;
import com.themisdarelis.processtool.model.ProcessInfo;

public class MainPanel extends JPanel {
    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("Welcome to Process Tool"));
        this.add(new JButton("Start Process"));

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

        //fonst staff
        Font largeFont = new Font("SansSerif", Font.PLAIN, 24);
        processTable.setFont(largeFont);
        processTable.setRowHeight(32);
        TableCellRenderer renderer = processTable.getDefaultRenderer(Object.class);
        if (renderer instanceof DefaultTableCellRenderer) {
            ((DefaultTableCellRenderer) renderer).setFont(largeFont);
        }
        JScrollPane scrollPane = new JScrollPane(processTable);
        this.add(scrollPane);
    }

}
