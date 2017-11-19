package parallelcompute;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Janita on 2017/11/19- 17:59
 * 该类是:
 */
public class Plus implements Runnable {
    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i + msg.j;
                Multiply.bq.add(msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
