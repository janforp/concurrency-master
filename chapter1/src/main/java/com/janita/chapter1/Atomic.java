package com.janita.chapter1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Janita on 2017/11/11- 10:26
 * 该类是:
 */
public class Atomic {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger();
        boolean b = integer.compareAndSet(1, 2);
        System.out.println("\n****************** " + b);
    }
}
