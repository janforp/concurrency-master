package future1;

/**
 * Created by Janita on 2017/11/18- 14:49
 * 该类是:
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                future.setRealData(realData);
            }
        }.start();

        return future;
    }
}
