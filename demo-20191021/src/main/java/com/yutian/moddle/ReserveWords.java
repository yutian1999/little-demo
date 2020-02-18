/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version ReserveWords.java, v 0.1 2020-02-17 17:10
 */
public class ReserveWords {

   /*
   给定一个字符串，逐个翻转字符串中的每个单词。

    示例 1：

    输入: "the sky is blue"
    输出: "blue is sky the"
    */

    @Test
    public void test() {
        String s = "the sky  is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public String reverseWords(String s) {
        if (null == s || "".equals(s)) {
            return s;
        }
        s = s.trim();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length / 2; i++) {
            String temp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = temp;
        }
        String rs = "";
        for (int i = 0; i < str.length; i++) {
            if ("".equals(str[i])) {
                continue;
            }
            if (i == str.length - 1) {
                rs += str[i];
            } else {
                rs += str[i] + " ";
            }
        }
        return rs.trim();
    }
}
