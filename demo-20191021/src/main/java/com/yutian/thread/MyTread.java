/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

/**
 * @author wengyz
 * @version MyTread.java, v 0.1 2020-01-07 12:10
 */
public class MyTread implements Runnable {

    private static int num = 0;

    private String name;

    public MyTread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        num++;
        System.out.println(name + "num:" + num);
    }
}
