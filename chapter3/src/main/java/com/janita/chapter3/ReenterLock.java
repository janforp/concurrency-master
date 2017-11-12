package com.janita.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janita on 2017/11/12- 15:49
 * 该类是:
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    public void run() {
        for (int j = 0; j < 100000 ; j ++) {
            lock.lock();
            lock.lock();
            try {
                i ++ ;
            }finally {
                lock.unlock();
                lock.unlock();
//                多放一次会报错
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(t1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("\n****************** " + i);
    }
}
