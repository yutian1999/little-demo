/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;


import org.junit.Test;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * @author wangyz
 * @version Solution.java, v 0.1 2019-11-25 14:59
 */
public class Solution {

    @Test
    public void test() {
        String s = "abcabcbb"; // abcabcdc

        int noRepeatNum = getNoRepeatNum(s);
        System.out.println(noRepeatNum);
    }


    public int getNoRepeatNum(String s) {


        // 以上三种情况返回0
        if (s == null || s == "" || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        char ch;
        int maxlength = 0;
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            ch = chars[i];
            temp = secondRepeatCharIndex(i, chars);

            maxlength = maxlength > temp ? maxlength : temp;
        }

        if (maxlength == 0) {
            maxlength = s.length();
        }

        return maxlength;
    }

    private int secondRepeatCharIndex(int start, char[] chars) {
        char repeat = chars[start];
        int length = 0;
        for (int i = start + 1; i < chars.length; i++) {
            if (repeat == chars[i]) {
                if (i == chars.length - 1) {
                    if (chars[i] != repeat)
                        length = i - start + 1;
                }
                length = i - start;
            }
        }

        return length;
    }


}