/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * @author wengyz
 * @version MyLock.java, v 0.1 2020-03-07 20:44
 */
public class MyLock {

    private int state = 0;

    private Thread lockHolder;

    private ConcurrentLinkedQueue<Thread> waiters = new ConcurrentLinkedQueue<>();

    private static final Unsafe unsafe = UnsafeInstance.getInstance();

    private static long stateOffset;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(MyLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加锁
     */
    public void lock() {
        // 同步获取锁
        if (acquire()) {
            return;
        }
        Thread current = Thread.currentThread();
        // 获取锁失败的 添加进队列里
        waiters.add(current);
        // 自旋加锁
        for (; ; ) {
            if (current == waiters.peek() && acquire()) {
                // 移除队列
                waiters.poll();
                break;
            }
            // 让出cpu的使用权
            LockSupport.park(current);
        }
    }

    /**
     * 解锁
     */
    public void unlock() {
        // 1.校验释放锁的线程是不是当前持有锁的线程
        if (Thread.currentThread() != lockHolder) {
            throw new RuntimeException("threadHolder is not current thread");
        }
        // 2. 释放锁修改state
        if (getState() == 1 && compareAndSwapState(1, 0)) {
            // 将锁的持有线程置为空
            setLockHolder(null);
            // 2.唤醒队列里的第一个线程
            Thread first = waiters.peek();
            if (first != null) {
                LockSupport.unpark(first);
            }
        }

    }

    private boolean acquire() {
        int state = getState();
        Thread current = Thread.currentThread();
        // 获取锁成功有两种情况 第一种是第一个获取到的队列里没有等待的  第二种是唤醒队列里等待的线程
        if ((waiters.size() == 0 || current == waiters.peek()) && state == 0) {
            // 没有线程获取到锁
            if (compareAndSwapState(0, 1)) {
                // 同步修改成功 将线程持有者修改为当前线程
                setLockHolder(current);
                return true;
            }
        }
        return false;
    }


    public final boolean compareAndSwapState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, expect, update);
    }

    /**
     * Getter method for property <tt>state</tt>.
     *
     * @return property value of state
     */
    public int getState() {
        return state;
    }

    /**
     * Setter method for property <tt>state</tt>.
     *
     * @param state value to be assigned to property state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * Getter method for property <tt>threadHolder</tt>.
     *
     * @return property value of threadHolder
     */
    public Thread getLockHolder() {
        return lockHolder;
    }

    /**
     * Setter method for property <tt>threadHolder</tt>.
     *
     * @param lockHolder value to be assigned to property threadHolder
     */
    public void setLockHolder(Thread lockHolder) {
        this.lockHolder = lockHolder;
    }
}
