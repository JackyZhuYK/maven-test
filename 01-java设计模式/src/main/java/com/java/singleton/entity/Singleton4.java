package com.java.singleton.entity;

/**
 * 懒汉式
 */
public class Singleton4 {
    private volatile static Singleton4 INSTANCE = null;

    public static Singleton4 getInstance(){
        if(INSTANCE==null){
            synchronized (Singleton4.class){
                if(INSTANCE==null){
                    INSTANCE = new Singleton4();
                }
            }

        }

        return INSTANCE;
    }

    private Singleton4() {

    }

}
