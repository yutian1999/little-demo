/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wengyz
 * @version ValidStr.java, v 0.1 2019-12-16 14:50
 */
public class ValidStr {

    /*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true*/

    @Test
    public void test() {
        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }


    /**
     * 判断有效字符串 时间复杂度是O(n) 空间复杂度O(m)
     *
     * @param s
     * @return
     */
    private boolean isValid(String s) {

        if ("".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                // 左括号进栈
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    // 是右括号先出现
                    return false;
                } else {
                    // 出现右括号
                    String str = stack.peek() + "" + s.charAt(i);
                    if (str.equals("()") || str.equals("{}") || str.equals("[]")) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }


    /**
     * 判断有效字符串 时间复杂度是O(n) 空间复杂度O(m)
     *
     * @param s
     * @return
     */
    private boolean isValid2(String s) {

        if ("".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                // 左括号进栈
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    // 是右括号先出现
                    return false;
                } else {
                    // 出现右括号 判断栈顶元素与当前元素是否是同一类型的括号
                    if ((stack.peek() == '(' && s.charAt(i) == ')')
                            || (stack.peek() == '[' && s.charAt(i) == ']')
                            || (stack.peek() == '{' && s.charAt(i) == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }


}
