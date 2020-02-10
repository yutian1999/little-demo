/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

/**
 * @author wengyz
 * @version ThreadLocalThread.java, v 0.1 2020-01-30 13:51
 */
public class ThreadLocalThread extends Thread {

    private volatile ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private Integer no;

    public ThreadLocalThread(Integer no) {
        this.no = no;
    }

    @Override
    public void run() {
        threadLocal.set("ThreadLocal-demo" + no);
        System.out.println("ThreadLocal-demo run NO." + no);
//        threadLocal.remove();
    }
}
