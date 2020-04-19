/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wengyz
 * @version TreeTest.java, v 0.1 2020-02-06 18:54
 */
public class TreeTest {
    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 相同树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // 前序输出  反转 然后中序遍历输出
    @Test
    public void test1() {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        prePrint(tree);
        System.out.println();
        TreeNode reverse = reverse(tree);
        midPrint(reverse);
        System.out.println();

        System.out.println(height(tree));

    }

    /**
     * 前序输出
     *
     * @param treeNode
     */
    private void prePrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.print(treeNode.val + "\t");
        prePrint(treeNode.left);
        prePrint(treeNode.right);
    }

    /**
     * 中序输出
     *
     * @param treeNode
     */
    private void midPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        midPrint(treeNode.left);
        System.out.print(treeNode.val + "\t");
        midPrint(treeNode.right);
    }

    private int height(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    /**
     * @param node
     * @return
     */
    private int min(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }

        if (node.left == null && node.right != null) {
            return Math.min(node.val, min(node.right));
        }

        if (node.left != null && node.right == null) {
            return Math.min(node.val, min(node.left));
        }

        return Math.min(Math.min(node.val, min(node.left)), min(node.right));
    }

    private List<Integer> levels = new ArrayList<>();

    private List<Integer> maxByLevel(TreeNode root) {
        maxHelp(root, 0);
        return levels;
    }

    private void maxHelp(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (levels.size() == level) {
            levels.add(node.val);
        } else {
            if (node.val > levels.get(level)) {
                levels.set(level, node.val);
            }
        }
        maxHelp(node.left, level + 1);
        maxHelp(node.right, level + 1);
    }


    @Test
    public void test11() {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(5);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(1);
        System.out.println(min(tree));

        System.out.println(maxByLevel(tree));
    }


    @Test
    public void test() {
        TreeNode tree = new TreeNode(3);

        System.out.println(height(tree));
    }

    /**
     * 二叉树反转
     *
     * @param treeNode
     * @return
     */
    private TreeNode reverse(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode right = reverse(treeNode.right);
        TreeNode left = reverse(treeNode.left);
        treeNode.right = left;
        treeNode.left = right;
        return treeNode;
    }



}
