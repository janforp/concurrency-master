package com.janita.chapter3;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017/11/13- 22:04
 * 该类是:
 */
public class ThreadFactoryDemo {

    public static class MyTask implements Runnable {
        public void run() {
            System.out.println("\n****************** " + System.currentTimeMillis()
                    + "Thread ID : " + Thread.currentThread().getId());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(
                5,
                5,
                0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setDaemon(true);
                        System.out.println("\n****************** 创建线程" );
                        return thread;
                    }
                }
        );

        for (int i = 0; i < 5; i++) {
            es.submit(task);
        }
    }
}
