/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wengyz
 * @version BinaryTree.java, v 0.1 2020-02-13 22:06
 */
public class BinaryTree {

    private class TreeNode {

        int val;

        TreeNode leftNode;

        TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    /**
     * 二叉树添加元素
     *
     * @param value
     */
    public void addNode(int value, TreeNode root) {

        if (root == null) {
            root = new TreeNode(value);
        }

        TreeNode curr = root;
        TreeNode parent;
        while (true) {
            parent = curr;
            if (value < curr.val) {
                curr = curr.leftNode;
                if (curr == null) {
                    parent.leftNode = new TreeNode(value);
                    return;
                }
            } else {
                curr = curr.rightNode;
                if (curr == null) {
                    parent.rightNode = new TreeNode(value);
                    return;
                }
            }

        }

    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraveral(node.leftNode);
        preOrderTraveral(node.rightNode);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftNode);
        System.out.print(node.val + " ");
        inOrderTraveral(node.rightNode);
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftNode);
        postOrderTraveral(node.rightNode);
        System.out.print(node.val + " ");
    }

    /**
     * 判断树是否是平衡树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.leftNode) - height(root.rightNode)) < 2
                && isBalanced(root.leftNode) && isBalanced(root.rightNode);
    }

    /**
     * 获取树的高度
     *
     * @param node
     * @return
     */
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.leftNode), height(node.rightNode));
    }

    /**
     * 获取树的最小高度
     *
     * @param root
     * @return
     */
    public int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.leftNode == null && root.rightNode == null) {
            return 1;
        }

        int deep = Integer.MAX_VALUE;

        if (root.leftNode != null) {
            deep = Math.min(minHeight(root.leftNode), deep);
        }

        if (root.rightNode != null) {
            deep = Math.min(minHeight(root.rightNode), deep);
        }

        return 1 + deep;
    }

    List<List<Integer>> levels = new ArrayList<>();

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        levelHelper(root, 0);
        return levels;
    }

    private void levelHelper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(root.val);

        if (root.leftNode != null) {
            levelHelper(root.leftNode, level + 1);
        }

        if (root.rightNode != null) {
            levelHelper(root.rightNode, level + 1);
        }
    }

    /**
     * 反转二叉树
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.leftNode);
        TreeNode right = invertTree(root.rightNode);
        root.rightNode = left;
        root.leftNode = right;
        return root;
    }


    @Test
    public void test() {
        BinaryTree tree = new BinaryTree();
        TreeNode node = new TreeNode(4);
        for (int i = 0; i < 10; i++) {
            tree.addNode(i + 2, node);
        }
        System.out.println("前序排列：");
        preOrderTraveral(node);

        System.out.println();
        System.out.println("中序排列：");
        inOrderTraveral(node);

        System.out.println();
        System.out.println("后序排列：");
        postOrderTraveral(node);
    }


}
