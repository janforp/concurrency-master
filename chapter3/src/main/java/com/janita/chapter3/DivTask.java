package com.janita.chapter3;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017/11/14- 19:57
 * 该类是:
 */
public class DivTask implements Runnable {
    int a,b;
    public DivTask(int a, int b) {
        this.a=a;
        this.b=b;
    }
    public void run() {
        double re = a/b;
        System.out.println("\n****************** " +  re);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                0,Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>()
        );

        for (int i = 0; i < 5; i++) {
            //没有错误日志
            Future<?> future = poolExecutor.submit(new DivTask(100, i));
            future.get();
//            有日志，但是不知道是哪个线程抛出的异常
            poolExecutor.execute(new DivTask(100, i));
        }
    }
}
