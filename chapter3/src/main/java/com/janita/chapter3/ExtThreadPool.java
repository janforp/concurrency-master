package com.janita.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janita on 2017/11/13- 22:19
 * 该类是:
 */
public class ExtThreadPool {

    public static class MyTask implements Runnable {
        public String name;

        MyTask(String name) {this.name = name;}

        public void run() {
            System.out.println("\n****************** 正在执行 Thread ID " + Thread.currentThread().getId() + "， Task Name :" + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(
                5,5,0, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>() {
                    protected void beforeExecute(Thread t, Runnable r) {
                        System.out.println("\n****************** 正在准备执行" + ((MyTask)r).name);
                    }

                    protected void afterExecute(Thread t, Runnable r) {
                        System.out.println("\n****************** 执行完成" + ((MyTask)r).name);
                    }

                    private void terminated() {
                        System.out.println("\n****************** 线程池退出" );
                    }
                }
        );

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK - " + i);
            es.execute(task);
            Thread.sleep(10);
        }

        es.shutdown();
    }
}