import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Janita on 2017/11/15- 22:03
 * 该类是:
 */
public class ThreadLocalDemo {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ParseDate implements Runnable{
        int i = 0;
        ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                synchronized (sdf) {
                    Date t = sdf.parse("2215-03-29 19:29:"+i%60);
                    System.out.println("\n****************** " + i +" : " + t);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            es.execute(new ParseDate(i));
        }
    }
}
