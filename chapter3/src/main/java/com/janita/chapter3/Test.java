package com.janita.chapter3;

/**
 * Created by Janita on 2017/11/12- 19:51
 * 该类是:
 */
public class Test {

    public static void main(String[] args) {
        mark:
        for (int i=0;i<100;i++) {
            if (i %2 ==0) {
                continue mark;
            }
            System.out.println("\n****************** " + i);
        }
    }
}
