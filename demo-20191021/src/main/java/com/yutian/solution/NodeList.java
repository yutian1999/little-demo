/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.solution;

import org.junit.Test;

/**
 * -----链表-----
 * 206，141，21，19，876
 *
 * @author wengyz
 * @version NodeList.java, v 0.1 2020-01-02 22:18
 */
public class NodeList {

    /**
     * 测试
     */
    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        printLinked(node);
        ListNode node1 = reverseList(node);
        printLinked(node1);
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        ListNode preNode = null;
        while (currNode != null) {
            // 先取出 下一个节点 用于循转  pre - curr - next
            ListNode nextTemp = currNode.next;
            // 当前节点的下一个节点指向pre  curr - pre
            currNode.next = preNode;
            // pre -
            preNode = currNode;
            currNode = nextTemp;
        }
        return preNode;
    }

    /**
     * 打印链表
     */
    public void printLinked(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val + "->");
            node = node.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}

/**
 * 链表
 */
class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}
