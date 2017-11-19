package parallelcompute;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Janita on 2017/11/19- 17:56
 * 该类是:
 */
public class Div implements Runnable {

    public static BlockingQueue<Msg> bq = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Msg msg = bq.take();
                msg.i = msg.i / 2 ;
                System.out.println("\n****************** " + msg.orgStr + " = " + msg.i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
