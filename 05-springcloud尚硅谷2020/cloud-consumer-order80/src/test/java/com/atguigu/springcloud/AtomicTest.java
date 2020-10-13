package com.atguigu.springcloud;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {


    public static void main(String[] args) {
        AtomicSpin atomicSpin = new AtomicSpin();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    atomicSpin.getAndSet();
                    System.out.println(atomicSpin.number.get());
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100000;i++){
                    atomicSpin.getAndSet();
                    System.out.println(atomicSpin.number.get());
                }

            }
        });

        t1.start();
        t2.start();
    }

    static class AtomicSpin {
        public AtomicInteger number = new AtomicInteger(0);

        int getAndSet(){
            int num = 0;
            int target = 0;
            do {
                num = number.get();
                target = num>=Integer.MAX_VALUE?0:num+1;
            }while (!number.compareAndSet(num,target));

            return target;
        }
    }
}
