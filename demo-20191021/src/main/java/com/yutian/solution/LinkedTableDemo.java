/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wengyz
 * @version LinkedTableDemo.java, v 0.1 2019-12-30 20:56
 */
public class LinkedTableDemo {

//    我的思路是这样的：我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。
//    当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
//            1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，
//    然后再插入到链表的头部。
//            2. 如果此数据没有在缓存链表中，又可以分为两种情况：
//    如果此时缓存未满，则将此结点直接插入到链表的头部；
//    如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。这样我们就用链表实现了一个 LRU 缓存，是不是很简单？


    private volatile SortNode node;


//    private boolean insertNode(String s){
//
//        if (node == null){
//            node = new SortNode(s);
//            return true;
//        }
//
//        // 遍历链表
//        while (node.str != null){
//            String str = node.str;
//            if (s.equals(str)){
//                // 此数据在缓存中存在过 删除此节点 并将数据放在头节点
//            }else {
//               node = node.next;
//            }
//            break;
//        }
//
//
//        return false;
//    }


    /**
     * 有序链表
     */
    class SortNode {

        private String str;

        private SortNode next;

        public SortNode(String str) {
            this.str = str;
        }

        public void remove() {

        }
    }

    // 最近不经常使用策略


    private LinkedList<String> linkedList = new LinkedList<String>();

    /**
     * 插入链表
     *
     * @param s
     */
    private void insertNode(String s) {

        if (linkedList.contains(s)) {
            // 已经存在 删除
            linkedList.remove(s);
            // 放在链表头部
            linkedList.addFirst(s);
        } else {
            if (linkedList.size() >= 5) {
                // 最多存5个 过期尾部最不经常使用的
                linkedList.removeLast();
                linkedList.addFirst(s);
            } else {
                linkedList.addFirst(s);
            }
        }
    }

    @Test
    public void testNode() {
        for (int i = 0; i < 10; i++) {
            insertNode("node-" + i);
            insertNode("node-100");
        }
        System.out.println(linkedList);
    }


    private List<String> list = new ArrayList<>();

    /**
     * 插入数组
     *
     * @param s
     */
    private void insertArr(String s) {
        Iterator<String> iterator = list.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            if (s.equals(iterator.next())) {
                // 存在 删除 插入表头
                iterator.remove();
                flag = true;
            }
        }

        if (!false) {
            // 不存在
            if (list.size() >= 5) {
                // 缓存满了
                list.remove(0);
                list.add(s);
            } else {
                // 没有满
                list.add(s);
            }
        }
    }

    /**
     *
     */
    @Test
    public void testArr() {
        for (int i = 0; i < 10; i++) {
            insertArr("arr-" + i);
            insertArr("arr-" + 100);
            insertArr("arr-" + 101);
        }
        System.out.println(list);
    }

}
