/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.LinkedTable;

/**
 * @author wengyz
 * @version Linked.java, v 0.1 2020-02-09 11:51
 */
public class Linked<T> {

    private class Node<T> {

        public T t;

        public Node next;

        public Node(T t) {
            this(t, null);
        }

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }

    private Node head;

    private int size;

    public Linked() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 链表头部添加元素
     *
     * @param t
     */
    public void addFirst(T t) {
        Node<T> node = new Node<T>(t);
        // 将新节点的next指向原来的头节点  newNode.next -> head
        node.next = this.head;
        // 将新节点赋值给头节点 newNode -> oldHead ->
        this.head = node;
        this.size++;
    }

    /**
     * 链表尾部添加元素
     *
     * @param t
     */
    public void addLast(T t) {
        this.add(t, this.size);
    }

    /**
     * 指定位置插入
     *
     * @param t
     * @param index
     */
    public void add(T t, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }

        if (index == 0) {
            this.addFirst(t);
            return;
        }
        Node preNode = this.head;
        // 找到要插入的前一个节点
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }

        //将链表链上
        Node node = new Node(t);
        // node - > next
        node.next = preNode.next;
        // pre - > node - > next
        preNode.next = node;
        this.size++;
    }

    /**
     * 指定位置删除
     *
     * @param index
     * @return
     */
    public Object delect(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index error");
        }
        Object t = null;
        // 头节点删除
        if (index == 0) {
            t = head.t;
            head = head.next;
            this.size--;
            return t;
        }

        // 找到要删除节点的前一个节点 和 后一个节点
        Node preNode = this.head;
        Node nextNode = this.head;
        int preIndex = index - 1;
        for (int i = 0; i < index + 1; i++) {
            if (i < preIndex) {
                preNode = preNode.next;
            }

            if (i == preIndex) {
                nextNode = preNode;
                nextNode = nextNode.next;
                t = nextNode.t;
            }

            if (i == preIndex + 1) {
                nextNode = nextNode.next;
            }
        }
        preNode.next = nextNode;
        this.size--;
        return t;
    }

    /**
     * 删除指定元素
     *
     * @param t
     */
    public void remove(T t) {
        if (head == null) {
            System.out.println("无元素可删除");
            return;
        }

        // 如何解决head不断重复的问题
        while (head != null && t.equals(head.t)) {
            head = head.next;
            this.size--;
        }

        if (head == null) {
            System.out.println("无元素可删除");
            return;
        }

        Node currNode = head;
        while (currNode.next != null) {
            if (currNode.next.t.equals(t)) {
                currNode.next = currNode.next.next;
                this.size--;
            } else {
                currNode = currNode.next;
            }
        }
    }

    /**
     * 链表反转
     */
    public void reverse() {
        Node curr = head;
        Node pre = null;
        while (curr != null) {
            // 取出next备用
            Node next = curr.next;
            // next 指向 pre
            curr.next = pre;
            // pre = curr
            pre = curr;
            // curr 往下传递
            curr = next;
        }
        head = pre;
    }

    /**
     * 获取链表大小
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 打印链表
     */
    public void printLinked() {
        Node node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.t.toString() + "->");
            node = node.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
}
