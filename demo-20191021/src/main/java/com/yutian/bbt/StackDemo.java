/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.bbt;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wengyz
 * @version StackDemo.java, v 0.1 2020-02-07 20:24
 */
public class StackDemo {

    // 给定一个全是小括号的字符串，为了使所有小括号配对，将两侧补充的括号输出
    @Test
    public void test() {
        String s = "((((((((())))(()))))))()(((())))";
        String addStr = getAddStr(s);
        System.out.println(addStr);
    }

    /**
     * 补充不对称的括号   (((
     *
     * @param s
     * @return
     */
    private String getAddStr(String s) {

        Stack<Character> stack = new Stack<Character>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            if ('(' == s.charAt(i)) {
                // 遇到"("入栈
                stack.push('(');
            }

            if (')' == s.charAt(i)) {
                if (!stack.empty() && '(' == stack.peek()) {
                    // 配对成功 弹出栈顶元素
                    stack.pop();
                } else {
                    // 配对失败 将")"存入栈顶
                    stack.push(s.charAt(i));
                }
            }
        }
        String s1 = stack.toString();
        return s1;
    }
}
