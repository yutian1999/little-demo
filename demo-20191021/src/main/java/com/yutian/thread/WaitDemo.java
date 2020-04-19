/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

/**
 * @author wengyz
 * @version WaitDemo.java, v 0.1 2020-04-12 22:42
 */
public class WaitDemo {

    private static Object lock = new Object();
    private static boolean flag = true;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (flag) {
                        try {
                            System.out.println("wait start .......");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("wait end ....... ");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (flag) {
                    synchronized (lock) {
                        if (flag) {
                            lock.notify();
                            System.out.println("notify .......");
                            flag = false;
                        }

                    }
                }
            }
        }).start();
    }
}
