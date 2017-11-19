package jdkfuture;



import java.util.concurrent.Callable;

/**
 * Created by Janita on 2017/11/19- 15:40
 * 该类是:
 */
public class RealDate implements Callable<java.lang.String> {
    private String param;

    RealDate(String param) {
        this.param = param;
    }

    @Override
    public java.lang.String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            try {
                Thread.sleep(100);
            }catch (Exception ignored) {}
        }
        return sb.toString();
    }
}
