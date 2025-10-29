package com.themisdarelis.processtool.model;

public class ProcessInfo {
  private String user;
    private String command;
    private long pid;

    public ProcessInfo(String command, long pid, String user) {
        this.command = command;
        this.pid = pid;
        this.user = user;
    }

    public String getCommand() {
        return command;
    }

    public long getPid() {
        return pid;
    }

    public String getUser() {
        return user;
    }

}
