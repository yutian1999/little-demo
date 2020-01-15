/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wengyz
 * @version ThreadPool.java, v 0.1 2020-01-09 14:50
 */
public class ThreadPool {

    private static volatile ExecutorService pool = null;

    /**
     * 创建线程池
     *
     * @return
     */
    public static ExecutorService getThreadPool() {
        synchronized (ThreadPool.class) {
            if (pool == null) {
                int cpuNum = Runtime.getRuntime().availableProcessors();
                int threadNum = cpuNum * 2 + 1;
                pool = new ThreadPoolExecutor(threadNum, threadNum, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
            }
        }
        return pool;
    }
}
