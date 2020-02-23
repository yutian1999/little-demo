/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

/**
 * @author wengyz
 * @version MyHashSet.java, v 0.1 2020-02-21 19:01
 */
public class MyHashSet {

    private final int SIZE = 10000;

    private int[] hash;

    public MyHashSet() {
        hash = new int[SIZE];
    }

    public void add(int key) {
        hash[key] = 1;
    }

    public void remove(int key) {
        hash[key] = 0;
    }

    public boolean contains(int key) {
        if (hash[key] == 1) {
            return true;
        }
        return false;
    }
}
