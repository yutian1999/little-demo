/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.tree;

/**
 * @author wengyz
 * @version BinaryTree.java, v 0.1 2020-02-06 19:16
 */
public class BinaryTree implements Tree {

    private Node node;

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    @Override
    public Node find(int key) {
        return null;
    }


    @Override
    public void insert(int key) {
        // 第一个节点
        if (node == null) {
            node = new Node(key);
        } else {
            // 非第一个节点 遍历插入
            if (key > node.data) {
                // 右节点
                Node rchild = node.rchild;
                insert(key);

            } else {
                // 左节点
                Node lchild = node.lchild;
                insert(key);
            }
        }
    }


    @Override
    public void delete(int key) {

    }

    /**
     * 遍历打印二叉树
     */
    @Override
    public void printTree() {
        Node currNode = node;
        System.out.println("root:\t" + currNode.data);
        while (!(currNode.lchild == null && currNode.rchild == null)) {
            if (currNode.lchild != null) {
                System.out.print("lnode:" + currNode.lchild.data + "\t");
            }
            if (currNode.rchild != null) {
                System.out.println("rnode:" + currNode.rchild.data);
            }
            System.out.println();
        }
    }
}
