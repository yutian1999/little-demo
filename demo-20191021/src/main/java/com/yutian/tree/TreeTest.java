/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.tree;

import org.junit.Test;

/**
 * @author wengyz
 * @version TreeTest.java, v 0.1 2020-02-06 19:26
 */
public class TreeTest {

    private BinaryTree binaryTree = new BinaryTree();
    private Node node = new Node(8);


    @Test
    public void insert() {
        for (int i = 1; i < 6; i++) {
            binaryTree.insert(i);
        }
        Node node = new Node(10);
    }

    @Test
    public void test1() {
        node.lchild = new Node(7);
        node.rchild = new Node(9);
        node.print();
    }
}
