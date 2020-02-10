/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.concurrent.Callable;

/**
 * @author wengyz
 * @version HotWaterThread.java, v 0.1 2020-01-15 09:41
 */
public class HotWaterThread implements Callable<Boolean> {


    @Override
    public Boolean call() {
        System.out.println("烧水中。。。。。。");
        try {
            Thread.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
