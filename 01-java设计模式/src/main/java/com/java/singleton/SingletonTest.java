package com.java.singleton;

import com.java.singleton.entity.Singleton1;
import com.java.singleton.entity.Singleton2;
import com.java.singleton.entity.Singleton3;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();

        Singleton2 singleton2 = Singleton2.INSTANCE;

        Singleton3 singleton3 = Singleton3.INSTANCE;
        System.out.println(singleton3.getContent());
    }
}
