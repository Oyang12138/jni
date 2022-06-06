package com.example.learnjni;
//(Ljava/lang/String;)Ljava/lang/String;

public class MyTest {
    static {
        System.loadLibrary("mytest");
    }
    public native String WifiButton();

    public void returnTypeWife(int type){

    }
}
