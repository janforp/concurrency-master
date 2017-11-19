package jdkfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Janita on 2017/11/19- 17:39
 * 该类是:
 */
public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> future = new FutureTask<String>(new RealDate("a"));
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.submit(future);
       System.out.println("\n****************** wb");
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("\n****************** " + future.get());
    }
}
