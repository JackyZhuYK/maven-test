package com.java.singleton.entity;

/**
 * 静态内部类不会随外部类初始化而初始化，只有在用的时候才会初始化
 */
public class Singleton5 {

    public static Singleton5 getInstance(){
        return Inner.INSTANCE;
    }

    private Singleton5() {

    }

    private static class Inner {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
}
