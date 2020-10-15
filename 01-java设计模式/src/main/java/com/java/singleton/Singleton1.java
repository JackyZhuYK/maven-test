package main.java.java.singleton;

/**
 * 单例模式
 */
public class Singleton1 {//懒汉式
    private static volatile Singleton1 s1 = null;
    private Singleton1(){

    }
    public static synchronized Singleton1 getInstance(){
        if(s1 == null){
            s1 = new Singleton1();
        }
        return s1;
    }

}
