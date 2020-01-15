/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author wengyz
 * @version SumThread.java, v 0.1 2020-01-10 20:38
 */
public class SumThread implements Callable {

    private List<Integer> list;

    public SumThread(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }
}
