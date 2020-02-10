/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author wengyz
 * @version JoinTest.java, v 0.1 2020-01-10 20:41
 */
public class JoinTest {

    private List<Integer> list1 = new ArrayList<>();

    private List<Integer> list2 = new ArrayList<>();


    @Test
    public void test() throws Exception {
        Thread addThread = new AddElement(list1, list2);
        addThread.start();
        addThread.join();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future sum1 = pool.submit(new SumThread(list1));
        Future sum2 = pool.submit(new SumThread(list2));
        System.out.println(sum1.get());
        System.out.println(sum2.get());
    }


    @Test
    public void test2() throws ExecutionException, InterruptedException {
        FutureTask<Boolean> hotTask = new FutureTask<>(new HotWaterThread());
        Thread hotWater = new Thread(hotTask);
        FutureTask<Boolean> washTask = new FutureTask<>(new WashCupThread());
        Thread washCup = new Thread(washTask);
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(hotWater);
        pool.submit(washCup);
        Boolean h = hotTask.get();
        Boolean w = washTask.get();

        while (!(h && w)) {
            System.out.println("看书咯。。。。。");
        }

        System.out.println("泡茶了。。。。。");
        System.out.println("喝茶了。。。。。");
    }
}
