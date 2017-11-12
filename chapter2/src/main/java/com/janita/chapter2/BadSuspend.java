package com.janita.chapter2;


/**
 * Created by Janita on 2017/11/11- 22:30
 * 该类是:
 */
public class BadSuspend {

    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");


    public static class ChangeObjectThread extends  Thread{
        ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("\n****************** in " + getName());
                Thread.currentThread().suspend();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            t1.start();
            Thread.sleep(100);
            t2.start();
            t1.resume();
            t2.resume();
            t1.join();
            t2.join();
        }
    }
}
