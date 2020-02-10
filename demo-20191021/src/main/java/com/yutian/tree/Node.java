/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.tree;

/**
 * @author wengyz
 * @version Node.java, v 0.1 2020-02-06 19:07
 */
public class Node {

    public int data;

    public Node lchild;

    public Node rchild;

    public Node(int data) {
        this.data = data;
    }

    public void print() {
        System.out.println("   " + data);
        while (!(lchild == null && rchild == null)) {
            if (lchild != null) {
                System.out.print(lchild.data + "\t");
                lchild = lchild.lchild;
            }

            if (rchild != null) {
                System.out.println(rchild.data);
                rchild = rchild.rchild;
            }
        }
    }
}
