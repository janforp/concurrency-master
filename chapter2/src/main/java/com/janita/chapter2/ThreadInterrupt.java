package com.janita.chapter2;

/**
 * Created by Janita on 2017/11/11- 21:29
 * 该类是:
 */
public class ThreadInterrupt{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("\n****************** ");
                        break;
                    }
                    Thread.yield();
                }
            }
        };
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
