package consumerproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Janita on 2017/11/17- 21:08
 * 该类是:
 */
public class PCData {
    private final int intData;
    public PCData(int d) {
        intData = d;
    }

    PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data: " + intData;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);

        service.execute(c1);
        service.execute(c2);
        service.execute(c3);

        Thread.sleep(10 * 1000);
        p1.stop();
        p2.stop();
        p3.stop();

        Thread.sleep(3000);
        service.shutdown();
    }
}
