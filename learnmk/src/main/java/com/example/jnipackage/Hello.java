package com.example.jnipackage;

public class Hello {
    static {
        System.loadLibrary("hello-jni");
    }

    public native String getString();
}
