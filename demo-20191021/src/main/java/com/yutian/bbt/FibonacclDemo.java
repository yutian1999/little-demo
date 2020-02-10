/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.bbt;

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

    private List<Integer> createSeque(Integer n) {
        List<Integer> list = new ArrayList<>(n);
        list.add(1);
        list.add(1);
        for (int i = 2; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }

        return list;
    }
}
