/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

/**
 * @author wengyz
 * @version MyHashMap.java, v 0.1 2020-02-21 19:24
 */
public class MyHashMap {

    private int[] hashtable;

    private final int SIZE = 1000000;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        hashtable = new int[SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        hashtable[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = hashtable[key];
        if (i > 0) {
            return i;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        hashtable[key] = -1;
    }
}
