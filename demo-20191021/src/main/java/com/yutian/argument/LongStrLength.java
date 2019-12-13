/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wengyz
 * @version LongStrLength.java, v 0.1 2019-12-12 17:30
 */
public class LongStrLength {


    /**
     * 暴力解法
     *
     * @param str abcabcbb
     * @return
     */
    private int longStrLength(String str) {
        int maxLeng = 0;
        for (int i = 0; i < str.length(); i++) {

            Set<Character> set = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (set.contains(str.charAt(j))) {
                    break;
                }
                set.add(str.charAt(j));
            }

            maxLeng = Math.max(maxLeng, set.size());
        }
        return maxLeng;
    }

    /**
     * 双指针实现
     *
     * @param s
     * @return
     */
    private int longStrLengthBypoint(String s) {

        int maxlength = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;

        while (i < s.length() && j < s.length()) {

            if (!set.contains(s.charAt(j))) {
                // 不重复
                set.add(s.charAt(j));
                j++;
                maxlength = Math.max(maxlength, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxlength;

    }
}
