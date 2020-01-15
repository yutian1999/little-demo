/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.List;

/**
 * @author wengyz
 * @version AddElement.java, v 0.1 2020-01-10 20:34
 */
public class AddElement extends Thread {

    private List<Integer> list1;

    private List<Integer> list2;

    public AddElement(List<Integer> list1, List<Integer> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
    }
}
