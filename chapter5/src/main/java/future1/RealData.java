package future1;

/**
 * Created by Janita on 2017/11/18- 14:39
 * 该类是:
 */
public class RealData {

    protected final String result;

    public RealData(String para) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }

    public String  getResult() {
        return result;
    }
}
