/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.LinkedTable;

/**
 * @author wengyz
 * @version LRUUtil.java, v 0.1 2020-02-09 16:38
 */
public class LRUUtil {

    public static volatile Linked<String> list = new Linked<String>();

    /**
     * lru算法添加
     *
     * @param t
     */
    public static void add(String t) {
        // 删除指定元素
        if (list.getSize() != 0) {
            list.remove(t);
        }
        // 判断容量，假设只能存10个，删除最后一个元素
        if (list.getSize() == 10) {
            list.delect(9);
        }
        // 将当前元素添加到最前面
        list.addFirst(t);
    }

    /**
     * lru使用
     *
     * @param t
     */
    public static void use(String t) {
        add(t);
    }
}
