/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.LinkedTable;

import org.junit.Test;

/**
 * @author wengyz
 * @version LinkedTest.java, v 0.1 2020-02-09 12:07
 */
public class LinkedTest {

    /**
     * 插入链表头部
     */
    @Test
    public void addFirstTest() {
        Linked<String> linked = new Linked<String>();
        linked.addFirst("1");
        linked.addFirst("2");
        linked.addFirst("3");
        linked.addFirst("4");
        linked.addFirst("5");
        linked.printLinked();
        linked.reverse();
        linked.delect(linked.getSize() - 3);
        linked.printLinked();
    }

    /**
     * 按index 插入链表
     */
    @Test
    public void addIndexTest() {
        Linked<String> linked = new Linked<String>();
        linked.add("1", 0);
        linked.add("2", 1);
        linked.add("0", 0);
        linked.add("3", 3);
        linked.printLinked();
    }

    /**
     * 链表表尾插入
     */
    @Test
    public void addLast() {
        Linked<Integer> linked = new Linked<>();
        linked.addLast(1);
        linked.addLast(2);
        linked.printLinked();
    }

    /**
     * 删除节点 by index  0 -> 1 -> 2 -> 3
     */
    @Test
    public void delectByIndex() {
        Linked<String> linked = new Linked<String>();
        linked.add("1", 0);
        linked.add("2", 1);
        linked.add("0", 0);
        linked.add("3", 3);
        Object delect = linked.delect(0);
        linked.printLinked();
        System.out.println("删除：" + delect);
    }

    /**
     * 删除节点 by index  0 -> 1 -> 2 -> 3
     */
    @Test
    public void removeTest() {
        Linked<String> linked = new Linked<String>();
        linked.add("1", 0);
        linked.add("2", 1);
        linked.add("1", 0);
        linked.add("1", 3);
        linked.remove("1");
        linked.printLinked();
    }

    @Test
    public void lruTest() {
        for (int i = 0; i < 20; i++) {
            LRUUtil.add(String.valueOf(i));
        }
        LRUUtil.list.printLinked();
    }


}
