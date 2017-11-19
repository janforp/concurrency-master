package disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by Janita on 2017/11/18- 11:37
 * 该类是:
 */
public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData event) throws Exception {
        System.out.println("\n****************** " +Thread.currentThread().getId() + " Event: --" +
        event.get()  * event.get() + " --");
    }
}
