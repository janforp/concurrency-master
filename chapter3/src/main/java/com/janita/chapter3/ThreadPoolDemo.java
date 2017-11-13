package com.janita.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janita on 2017/11/13- 20:43
 * 该类是:
 */
public class ThreadPoolDemo {

    public static class MyTask implements Runnable {

        public void run() {
            System.out.println("\n****************** " + System.currentTimeMillis()
            + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
//        ExecutorService ex = Executors.newFixedThreadPool(5);
        ExecutorService ex = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            ex.submit(task);
        }
    }
}
