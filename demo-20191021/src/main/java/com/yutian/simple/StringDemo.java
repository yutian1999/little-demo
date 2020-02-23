/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

/**
 * @author wengyz
 * @version StringDemo.java, v 0.1 2020-02-20 15:38
 */
public class StringDemo {

    /**
     * s = nx n >= 2; s中至少有2个x
     * t = 2s = 2nx; t中至少有4个x
     * 去掉头尾
     * t = 2nx - 2
     * t中还有s
     *
     */

    /**
     * abcda abcda abcda
     * 判断一个字符串是否能由一个子串重复构成
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        t = t.substring(1, t.length() - 1);
        if (t.indexOf(s) > -1) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        String s = "abab";
        s.contains("11");
        System.out.println(repeatedSubstringPattern(s));
    }

    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    /**
     * 找文本中两个单词的距离
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minR = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
            }

            if (word2.equals(words[i])) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                minR = Math.min(minR, Math.abs(index1 - index2));
            }
        }
        return minR;
    }
}
