package com.janita.chapter3;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017/11/13- 21:50
 * 该类是:
 */
public class RejectThreadPoolDemo {
    
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

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService e = new ThreadPoolExecutor(
//                5,
//                5,
//                0,
//                TimeUnit.MICROSECONDS,
//                new LinkedBlockingDeque<Runnable>(10),
//                Executors.defaultThreadFactory()
////                (r, executor) -> System.out.println("\n****************** discard : " +  r.toString())
//        );
//
//        MyTask task = new MyTask();
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            e.submit(task);
//            Thread.sleep(100);
//        }
    }
}
