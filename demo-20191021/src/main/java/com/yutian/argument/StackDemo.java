/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wengyz
 * @version StackDemo.java, v 0.1 2019-12-09 09:19
 */
public class StackDemo {


    /**
     * java栈小demo
     */
    @Test
    public void stackDemo() {
        // 初始化栈
        Stack<Integer> stack = new Stack<Integer>();

        // 压入栈
        stack.push(18);
        stack.push(19);
        stack.push(18);

        // 弹出栈顶
        stack.pop();

        System.out.println(stack);

        // 返回栈顶内容
        Integer peek = stack.peek();
        System.out.println(peek);
    }

    /*
     * 给定一个只包括 ‘(’，’)'的字符串，判断字符串是否有效。注：空字符串属于有效字符串
     *  注意：这道题的字符串只允许'(' 和 ')'字符
     *
     */

    @Test
    public void inVaidStr() {
        String str = "(((()))";
        // 采用栈的方式
//        boolean b = checkStr(str);

        //  采用计数器的方式
        boolean b = checkStrByCounter(str);
        System.out.println(b);
    }

    /**
     * 给定一个只包含 ‘(’ 和 ‘)’ 的字符串，找出最长的包含有效括号的子串的长度。
     */
    @Test
    public void getVaidStrLength() {
        String str = ")))(((((()";
        int length = getVaidStrLength(str);
        System.out.println(length);
    }

    /**
     * 获得最大有效字符串长度
     *
     * @param str
     * @return
     */
    private int getVaidStrLength(String str) {

        int max = 0;
        if (null == str || "" == str || str.length() < 2) {
            return max;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 弹出栈顶元素
                stack.pop();

                // 如果栈里没有数据 把当前的下标压入栈中
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }


    // 采用栈来处理这道题 遇见"("入栈，遇到")"弹出配对
    private boolean checkStr(String s) {

        if (null == s || "" == s || s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        // 获取字符串长度
        int length = s.length();

        for (int i = 0; i < length; i++) {

            // 遇见"("压入栈
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {

                // 此处是个优化
                if (stack.empty()) {
                    return false;
                }

                // 遇见")"将栈顶的"("压出
                if (s.charAt(i) == ')') {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }


    /**
     * 采用计数器的方式来解决
     */

    private boolean checkStrByCounter(String str) {

        if (null == str || "" == str || str.length() < 2) {
            return false;
        }

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                if (str.charAt(i) == ')') {
                    count--;
                }
            }
        }

        return count == 0 ? true : false;
    }

}
