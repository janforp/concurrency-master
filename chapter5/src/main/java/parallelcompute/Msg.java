package parallelcompute;

/**
 * Created by Janita on 2017/11/19- 17:57
 * 该类是:
 */
public class Msg {
    public double i ;
    public double j;
    public String orgStr = null;


    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for (int i = 0; i < 1000; i++) {

            for (int j = 0; j < 1000; j++) {

                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "(( " + i + "+" + j + " ) *" + i + ") / 2" ;
                Plus.bq.add(msg);
            }
        }
    }
}
