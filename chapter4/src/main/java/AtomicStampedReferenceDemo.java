import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by Janita on 2017/11/17- 19:50
 * 该类是:
 */
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<Integer> money
            = new AtomicStampedReference<>(19,0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int time = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m,m+20,time,time + 1)) {
                                    System.out.println("\n****************** " + "余额小于20，重置成功，余额 ：" +money.getReference() + " 元");
                                    break;
                                }
                            }else {
                                System.out.println("\n****************** " + "余额大于20，无须充值");
                                break;
                            }
                        }
                    }
                }
            }.start();
        }

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        int stamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("\n****************** " + "大于 10元");
                            if (money.compareAndSet(m,m-10,stamp,stamp +1)) {
                                System.out.println("\n****************** " + "成功消费10元,余额：" +money.getReference());
                                break;
                            }else {
                                System.out.println("\n****************** " + "余额不足");
                                break;
                            }
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {


                        }
                    }
                }
            }
        }.start();
    }

}
