package com.janita.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Janita on 2017/11/13- 19:55
 * 该类是:
 */
public class CyclicBarrierDemo {

    public static class Solider implements Runnable{
        private String soliderName;
        private CyclicBarrier cyclic;

        Solider(CyclicBarrier cyclic, String soliderName) {
            this.cyclic = cyclic;
            this.soliderName = soliderName;
        }

        public void run() {
            try {
                cyclic.await();
                doWord();
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWord() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n****************** 完成任务 " + soliderName);
        }
    }

    public static class  BarrierRun implements  Runnable {
        boolean flag;
        int N;

        BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        public void run() {
            if (flag) {
                System.out.println("\n****************** 司令 ：【士兵" + N + "个，完成任务");
            }else {
                System.out.println("\n****************** 集合完毕" );
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10 ;
        Thread[] threads = new Thread[N];
        boolean flag = false;
        CyclicBarrier barrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("\n****************** 队伍集合 " );
        for (int i = 0; i < N; i++) {
            System.out.println("\n****************** 士兵" + i+ "报到" );
            threads[i] = new Thread(new Solider(barrier, "士兵" + i));
            threads[i].start();
            if (i == 5) {
                threads[0].interrupt();
            }
        }
    }
}
