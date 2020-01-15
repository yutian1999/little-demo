/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

/**
 * @author wengyz
 * @version Foo.java, v 0.1 2020-01-02 21:22
 */
public class Foo {

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
//        Thread.sleep(100L);
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        foo.first(new Runnable() {
            @Override
            public void run() {
                System.out.print("one");
            }
        });

        foo.second(new Runnable() {
            @Override
            public void run() {
                System.out.print("two");
            }
        });

        foo.third(new Runnable() {
            @Override
            public void run() {
                System.out.print("three");
            }
        });
    }
}
