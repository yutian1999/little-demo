/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author wengyz
 * @version ThreadPoolDemo.java, v 0.1 2020-03-29 12:16
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(80, 150, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(200));
        long start = System.currentTimeMillis() / 1000;
        IntStream.range(0, 500).forEach(i -> {
            pool.submit(new MyThread());
            try {
                Thread.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
        System.out.println("use time " + (System.currentTimeMillis() / 1000 - start) + "秒");

    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500L);
                System.out.println(Thread.currentThread().getName() + "     run  ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
