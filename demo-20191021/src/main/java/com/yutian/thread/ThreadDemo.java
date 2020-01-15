/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import org.junit.Test;

import java.io.File;
import java.util.concurrent.ExecutorService;

/**
 * @author wengyz
 * @version ThreadDemo.java, v 0.1 2020-01-07 11:32
 */
public class ThreadDemo {


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new MyTread("Thread-1"));
        Thread t2 = new Thread(new MyTread("Thread-2"));
        Thread t3 = new Thread(new MyTread("Thread-3"));
        Thread t4 = new Thread(new MyTread("Thread-4"));
        Thread t5 = new Thread(new MyTread("Thread-5"));
        Thread t6 = new Thread(new MyTread("Thread-6"));
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        t5.start();
        t5.join();
        t6.start();
        t6.join();
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }


    @Test
    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 80; i++) {
            Thread t = new Thread(new MyTread("Thread-" + i));
            t.start();
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");
    }

    @Test
    public void test1() throws InterruptedException {
        Thread t1 = new Thread(new MyTread("Thread-1"));
        Thread t2 = new Thread(new MyTread("Thread-2"));
        Thread t3 = new Thread(new MyTread("Thread-3"));
        Thread t4 = new Thread(new MyTread("Thread-4"));

        t1.start();
        t2.start();
        t1.wait();
        t3.start();
        t3.notify();
        t4.start();
    }


    @Test
    public void test2() {
        ExecutorService threadPool = ThreadPool.getThreadPool();
        File file = new File("/Users/wengyuzhu/Desktop/图片.jpeg");
        for (int i = 0; i < 10; i++) {
            Thread t = new FileThread(file, "photo-" + i + ".jpeg");
            threadPool.submit(t);
        }
    }
}
