package com.janita.chapter3;

import java.util.concurrent.*;

/**
 * Created by Janita on 2017/11/14- 20:05
 * 该类是:
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {

    public TraceThreadPoolExecutor(int coreSize, int maxSize, long time, TimeUnit unit, BlockingQueue<Runnable> queue) {
        super(coreSize,maxSize,time,unit,queue);
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }


    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    public Exception clientTrace() {
        return new Exception("Client stack **************");
    }

    private Runnable wrap(final Runnable task, final  Exception clientStack, String threadName) {
        return new Runnable() {
            public void run() {
                try {
                    task.run();
                }catch (Exception e) {
                    clientStack.printStackTrace();
                    try {
                        throw e;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            }
        };
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new TraceThreadPoolExecutor(
                0,Integer.MAX_VALUE,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>()
        );

        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(new DivTask(100, i));
        }
    }

}
