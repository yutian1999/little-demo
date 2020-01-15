/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import com.yutian.argument.Student;
import org.junit.Test;

/**
 * @author wengyz
 * @version WaitDmo.java, v 0.1 2020-01-09 11:46
 */
public class WaitDmo {
    private Student s = new Student();

    class T1 extends Thread {
        @Override
        public void run() {
            synchronized (s) {
                try {
                    System.out.println("Hello T2");
                    if (s.getName() == null) {
                        s.wait();
                    }
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    class T2 extends Thread {
        @Override
        public void run() {
            synchronized (s) {
                try {
                    System.out.println("Hello T1");
                    s.setName("lily");
                    s.notify();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
