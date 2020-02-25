/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.bbt;

import org.junit.Test;

/**
 * @author wengyz
 * @version LinkedList.java, v 0.1 2020-02-24 20:20
 */
public class LinkedList {

    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        print(head);

        Node reverse = reverse(head);
        print(reverse);

        delect(reverse, 3);
        print(reverse);
    }

    private void print(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private Node reverse(Node head) {
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    private Node delect(Node node, int n) {
        Node curr = node;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == n - 1) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return node;
    }
}
