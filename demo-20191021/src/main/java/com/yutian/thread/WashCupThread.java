/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.concurrent.Callable;

/**
 * @author wengyz
 * @version WashCupThread.java, v 0.1 2020-01-15 09:43
 */
public class WashCupThread implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println("洗杯子中。。。。。。");
        try {
            Thread.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
