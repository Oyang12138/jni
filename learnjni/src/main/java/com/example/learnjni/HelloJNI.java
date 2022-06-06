package com.example.learnjni;

public class HelloJNI {
    static {
        System.loadLibrary("hellojni");
    }
    public native String getString();

}
