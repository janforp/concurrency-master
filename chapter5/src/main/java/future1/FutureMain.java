package future1;

/**
 * Created by Janita on 2017/11/18- 14:53
 * 该类是:
 */
public class FutureMain {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("\n****************** 请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n****************** " + data.getResult());


    }
}
