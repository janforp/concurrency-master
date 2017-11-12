package com.janita.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Janita on 2017/11/12- 21:53
 * 该类是:
 */
public class SemapDemo implements Runnable{

    final Semaphore semaphore = new Semaphore(5);

    public void run() {
        try {
            semaphore.acquire();
            System.out.println("\n****************** " + semaphore.availablePermits());

            Thread.sleep(2000);;
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i=0;i<20;i++) {
            exe.submit(demo);
        }
    }
}
