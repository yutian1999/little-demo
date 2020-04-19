/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import org.junit.Test;

/**
 * @author wengyz
 * @version MyLockTest.java, v 0.1 2020-03-09 13:18
 */
public class MyLockTest {

    private MyLock lock;

    private int trick = 100;

    @Test
    public void test() {
        for (int i = 0; i < 200; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(10L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if (trick > 0) {
                        trick--;
                    }

                }
            }).start();
        }

        try {
            Thread.sleep(500L);
            System.out.println("剩余的票数：" + trick);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
