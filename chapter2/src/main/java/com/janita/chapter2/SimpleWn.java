package com.janita.chapter2;

/**
 * Created by Janita on 2017/11/11- 22:11
 * 该类是:
 */
public class SimpleWn {

    final static Object object = new Object();

    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("\n****************** T1 start" + System.currentTimeMillis() );
                try {
                    System.out.println("\n****************** T1 等待" + System.currentTimeMillis());
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n****************** T1 结束" + System.currentTimeMillis());
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("\n****************** T2 开始,唤醒" + System.currentTimeMillis());
                object.notify();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
