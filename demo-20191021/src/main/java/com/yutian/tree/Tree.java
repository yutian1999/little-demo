/**
 * fshows.com
 * Copyright (C) 2013-2020All Rights Reserved.
 */
package com.yutian.tree;

/**
 * @author wengyz
 * @version Tree.java, v 0.1 2020-02-06 19:11
 */
public interface Tree {

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    Node find(int key);

    /**
     * 插入节点
     *
     * @param key
     */
    void insert(int key);

    /**
     * 删除节点
     *
     * @param key
     */
    void delete(int key);

    void printTree();
}