package com.java.singleton.entity;

/**
 * 单例模式-饿汉式1
 */
public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){

    }
    public static Singleton1 getInstance(){
        return INSTANCE;
    }

}
