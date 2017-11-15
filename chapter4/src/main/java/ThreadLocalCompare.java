import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Janita on 2017/11/15- 22:42
 * 该类是:
 */
public class ThreadLocalCompare {

    public static final int GEN_COUNT = 10000000;
    public static final int THREAD_CUN = 4 ;
    static ExecutorService es = Executors.newFixedThreadPool(THREAD_CUN);

    public static Random rnd = new Random(123);

    public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>(){
        @Override
        protected Random initialValue() {
            return new Random(123);
        }
    };

    public static class RndTask implements Callable<Long> {
        private int mode = 0;

        public RndTask(int mode) {
            this.mode = mode;
        }

        public Random getRandom() {
            if (mode == 0) {
                return rnd;
            }else if (mode == 1) {
                return tRnd.get();
            }else {
                return null;
            }
        }

        @Override
        public Long call() throws Exception {
            long b = System.currentTimeMillis();
            for (int i = 0; i < GEN_COUNT; i++) {
                getRandom().nextInt();
            }
            long e = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " spend " + (e - b) + "ms");
            return e-b;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            Future<Long>[] futs = new Future[THREAD_CUN];
            for (int i = 0; i < THREAD_CUN; i++) {
                futs[i]=es.submit(new RndTask(0));
            }
            long totaltime = 0 ;
            for (int i = 0; i < THREAD_CUN; i++) {
                totaltime += futs[i].get();
            }

            System.out.println("\n****************** " + "多个线程访问一个实例的时候，totaltime = " + totaltime);


            totaltime=0;
            for (int i = 0; i < THREAD_CUN; i++) {
                futs[i]=es.submit(new RndTask(1));
            }
            for (int i = 0; i < THREAD_CUN; i++) {
                totaltime += futs[i].get();
            }

            System.out.println("\n****************** " + "多个线程访问duo个实例的时候，totaltime = " + totaltime);
        }
    }
}
