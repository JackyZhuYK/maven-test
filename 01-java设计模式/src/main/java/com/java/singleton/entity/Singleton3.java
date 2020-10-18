package com.java.singleton.entity;

import java.io.IOException;
import java.util.Properties;

/**
 * 单例模式-饿汉式3
 */
public class Singleton3 {
    public static Singleton3 INSTANCE = null;
    private String content;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("singleton.properties"));
            String value = properties.getProperty("singleton.content");
            INSTANCE = new Singleton3(value);
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    private Singleton3(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
