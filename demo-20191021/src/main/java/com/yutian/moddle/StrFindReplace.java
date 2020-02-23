/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version StrFindReplace.java, v 0.1 2020-02-20 13:32
 */
public class StrFindReplace {

    /**
     * @param S
     * @param indexes
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String s = S;
        for (int i = 0; i < indexes.length; i++) {
            int j = S.indexOf(sources[i]);
            int m = S.lastIndexOf(sources[i]);
            if (j == indexes[i]) {
                s = s.replaceFirst(sources[i], targets[i]);
            }
            if (m == indexes[i]) {
            }
        }
        return s;
    }

    @Test
    public void test() {
        String s = "abcdefg";
        int[] indexs = {0, 4};
        String[] source = {"ab", "ef"};
        String[] targrt = {"hjww", "gg"};
        String replaceString = findReplaceString(s, indexs, source, targrt);
        System.out.println(replaceString);
    }
}
