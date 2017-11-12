package com.janita.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Janita on 2017/11/12- 19:17
 * 该类是:
 */
public class FairLock implements  Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println("\n****************** " + Thread.currentThread().getName());
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "a");
        Thread t2 = new Thread(fairLock, "b");
        t1.start();
        t2.start();

    }
}
