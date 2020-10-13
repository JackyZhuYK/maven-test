package com.atguigu.springcloud;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadMain {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        executorService.execute(()->{
            int i=1/0;
        });

        executorService.execute(()->{
            System.out.println("当线程池抛出异常后继续新的任务");
        });


    }
}
