/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wengyz
 * @version MinStack.java, v 0.1 2020-02-18 14:53
 */
public class MinStack {

    private Stack<Integer> data = new Stack<>();

    private Stack<Integer> help = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        data.push(x);
        if (help.empty() || data.peek() > x) {
            help.push(x);
        } else {
            help.push(help.peek());
        }
    }

    public void pop() {
        if (!data.empty()) {
            data.pop();
            help.pop();
        }
    }

    public int top() {
        if (!data.empty()) {
            return data.peek();
        }
        throw new RuntimeException("stack empty");
    }

    public int getMin() {
        if (!help.empty()) {
            return help.peek();
        }
        throw new RuntimeException("stack empty");
    }


    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        int min = stack.getMin();
        System.out.println(min);
    }
}
