/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wengyz
 * @version ThreadLocalDemo.java, v 0.1 2020-01-30 13:43
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3000, 15000, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(8000));
        for (int i = 0; i < 10000; i++) {
            Thread thread = new ThreadLocalThread(i + 1);
            pool.submit(thread);
        }
    }
}
