package com.janita.chapter2;

/**
 * Created by Janita on 2017/11/11- 21:45
 * 该类是:
 */
public class ThreadInterruptTwo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("\n****************** 中断了" );
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("\n****************** 在睡眠的时候中断" );

//                        Thread.currentThread().interrupt();
                    }
                }
            }
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
