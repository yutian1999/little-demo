/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.demo;

import java.util.Stack;

/**
 * @author wengyz
 * @version Demo.java, v 0.1 2020-02-26 10:31
 */
public class Demo {


    // 3.times do
//   puts 'hello world'
// end

//给定一个由小括号组成的随机字符串，如"()((()))))))((((((()()(", 如“()()”，如")()(",为了能使其中所有括号成对，将两侧「最少」需要补充的字符串输出。
// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法


    private static String print(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.empty() && stack.peek() == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        System.out.println(print("((((("));
    }
}
