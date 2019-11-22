/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author wangyz
 * @version ListNodeDemo.java, v 0.1 2019-11-22 15:20
 */
public class ListNodeDemo {

    public static void main(String[] args) {
        ListNode l1 =new ListNode(2);
        l1.next = new ListNode(4);
        ListNode next = l1.next;
        next.next = new ListNode(3);

        ListNode l2 =new ListNode(5);
        l2.next = new ListNode(6);
        ListNode l2next = l2.next;
        l2next.next = new ListNode(4);

        while (true){
            System.out.print(l1.val);
            l1 = l1.next;
            if (l1 == null){
                System.out.println();//换行
                break;
            }
            System.out.print("->");
        }

        while (true){
            System.out.print(l2.val);
            l2 = l2.next;
            if (l2 == null){
                System.out.println();//换行
                break;
            }
            System.out.print("->");
        }

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val = l1.val + l2.val;
        if (val > 10){

        }

        ListNode node = new ListNode(l1.val + l2.val);

        while (true){


            break;
        }

        return l1;
    }
}