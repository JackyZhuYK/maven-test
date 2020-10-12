package com.java.singleton;

public class Singleton2 {
    private static final Singleton2 s2 = new Singleton2();
    private Singleton2(){

    }
    public static Singleton2 getInstance(){
        return s2;
    }
}
