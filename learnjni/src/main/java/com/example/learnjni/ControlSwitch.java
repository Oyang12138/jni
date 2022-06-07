package com.example.learnjni;

public class ControlSwitch {
    static {
        System.loadLibrary("switch");
    }
    public native int getSwitchStatus();

    private int status;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
