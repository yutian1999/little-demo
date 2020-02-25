/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.solution;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    /**
     * 判断链表是否有环  注册表法
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode currNode = head;
        while (currNode != null) {
            if (!set.add(currNode)) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    /**
     * 判断链表是否有环  双指针 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4

    /**
     * 将两个有序链表拼接成一个有续链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 哨兵法合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    @Test
    public void test1() {
        int[] num1 = {1, 2, 3, 0, 0, 0, 0};
        int[] num2 = {1, 2, 4};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    /**
     * he合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            if (temp[p1] < nums2[p2]) {
                nums1[p++] = temp[p1++];
            } else {
                nums1[p++] = nums2[p2++];
            }
        }

        if (p1 < m) {
            System.arraycopy(temp, p1, nums1, p, m - p1);
        }

        if (p2 < m) {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
    }

    /**
     * he合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1.将链表反转
        ListNode reserve = reserve(head);
        // 2.删除第n个元素
        int count = 1;
        while (reserve != null) {
            if (count == n - 1) {
                reserve = reserve.next.next;
                break;
            }
            count++;
            reserve = reserve.next;
        }
        // 3.在将链表反转回来
        ListNode src = reserve(reserve);
        return src;
    }

    private ListNode reserve(ListNode listNode) {
        if (listNode == null) {
            return listNode;
        }

        ListNode curr = listNode;
        ListNode pre = null;
        while (curr != null) {
            // 找到下一个节点
            ListNode next = curr.next;
            // 当前节next点指向pre
            curr.next = pre;
            // pre = next
            pre = curr;
//            curr = next
            curr = next;
        }
        return pre;
    }

    /**
     * 寻找链表中间节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int m = count % 2 == 0 ? (count / 2) + 1 : count / 2;

        for (int i = 0; i < m; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr1 = headA;
        while (curr1 != null) {
            set.add(curr1);
            curr1 = curr1.next;
        }

        ListNode curr2 = headB;
        while (curr2 != null) {
            if (set.contains(curr2)) {
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }

    /**
     * 将两个链表翻转后求和
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }


    private int value(ListNode listNode) {
        ListNode curr = listNode;
        String s = "";
        while (curr != null) {
            s += curr.val;
            curr = curr.next;
        }
        return Integer.valueOf(s);
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Test
    public void test9() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }

    @Test
    public void test8() {
        System.out.println(0 % 10);
    }

    /**
     * 移除链表中的元素
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * 注册表法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet();
        ListNode curr = head;
        set.add(curr.val);
        while (curr != null) {
            ListNode next = curr.next;
            if (next == null) {
                break;
            }
            if (!set.add(next.val)) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    /**
     * 向下延伸法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates222(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            if (curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    @Test
    public void testDel() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        printLinked(node);
        deleteDuplicates(node);
        printLinked(node);
    }

    /**
     * 删除链表中所有重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicatess(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                ListNode temp = curr.next;
                while (temp != null && temp.next != null && temp.next.val == temp.val) {
                    temp = temp.next;
                }
                curr.next = temp.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
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
