package com.janita.chapter3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Janita on 2017/11/13- 20:57
 * 该类是:
 */
public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        ses.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(8000);
                    System.out.println("\n****************** " + System.currentTimeMillis()/1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
    }
}
