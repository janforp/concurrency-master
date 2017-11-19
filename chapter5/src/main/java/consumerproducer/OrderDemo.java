package consumerproducer;

/**
 * Created by Janita on 2017/11/19- 18:57
 * 该类是:
 */
public class OrderDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5,6,7,90,79};
        int[] arr2 = new int[9];
        int min= arr[0];
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            if (value < min) {
                min = value;
            }
        }
    }
}
