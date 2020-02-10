/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wengyz
 * @version GuavaTest.java, v 0.1 2020-01-16 15:03
 */
public class GuavaTest {

    private static Boolean hW = false;
    private static Boolean wC = false;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 创建烧水线程
        Callable<Boolean> hotWater = new HotWaterThread();
        // 创建洗杯子线程
        Callable<Boolean> washCup = new WashCupThread();
        // 构建java线程池
        ExecutorService jpool = Executors.newFixedThreadPool(2);
        // 构建guava线程
        ListeningExecutorService gpool = MoreExecutors.listeningDecorator(jpool);
        // 提交烧水线程
        ListenableFuture<Boolean> hotWaterFuture = gpool.submit(hotWater);
        // 烧水线程绑定异步回调
        Futures.addCallback(hotWaterFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                hW = true;
                System.out.println("烧水成功");
            }

            @Override
            public void onFailure(Throwable throwable) {
                hW = false;
                System.out.println("烧水失败");
            }
        });

        // 提交洗杯子线程
        ListenableFuture<Boolean> washCupFuture = gpool.submit(washCup);
        Futures.addCallback(washCupFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean aBoolean) {
                wC = true;
                System.out.println("洗杯子成功");
            }

            @Override
            public void onFailure(Throwable throwable) {
                wC = false;
                System.out.println("洗杯子失败");
            }
        });

        while (!(hW && wC)) {
            System.out.println("看书咯。。。。。。");
        }

        System.out.println("泡茶了。。。。。");
        System.out.println("喝茶了。。。。。");
        System.out.println(System.currentTimeMillis() - start + "毫秒");
    }
}
