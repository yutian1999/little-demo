/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

/**
 * @author wengyz
 * @version CommonStartWith.java, v 0.1 2020-02-20 11:53
 */
public class CommonStartWith {

    /**
     * 寻找数组元素的最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (common.length() > strs[i].length()) {
                common = commonPrefix(common, strs[i]);
            } else {
                common = commonPrefix(strs[i], common);
            }
        }
        return common;
    }


    private String commonPrefix(String a, String b) {
        if (a.startsWith(b)) {
            return b;
        }
        while (b != null) {
            b = b.substring(0, b.length() - 1);
            if (a.startsWith(b)) {
                return b;
            }
        }
        return "";
    }


    @Test
    public void test() {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
