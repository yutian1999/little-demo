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

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(node);
    }

    /**
     *
     * @param listNode 1->2->3->4->5->null
     * @return
     */
//    private ListNode reversList(ListNode listNode){
//        ListNode node = listNode;
//        while (listNode != null){
//            listNode.next =
//        }
//    }


}

class ListNode {

    int val;

    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        String s = val + "";
        while (next != null) {
            s = s + "->" + next.val;
            next = next.next;
        }
        return s + "-> null";
    }
}
