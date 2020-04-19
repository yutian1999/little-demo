/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wengyz
 * @version FibonacclDemo.java, v 0.1 2020-02-06 18:19
 */
public class FibonacclDemo {

    @Test
    public void test() {
        List<Integer> seque = createSeque(1000);
        System.out.println(seque);
    }

    /**
     * it's shit
     *
     * @param n
     * @return
     */
    private List<Integer> createSeque(Integer n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        list.add(1);
        for (int i = 2; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }

        return list;
    }

    // 斐波那契数列 fn = fn-1 + fn-2 n > 1  f0 = 0,f1 = 1;

    @Test
    public void testFib() {
        System.out.println(fib(6));
    }

    /**
     * @param n
     * @return
     */
    public int fib(int n) {
        int f0 = 0;
        int f1 = 1;

        if (n == 0) {
            return f0;
        }

        if (n == 1) {
            return f1;
        }

        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}
