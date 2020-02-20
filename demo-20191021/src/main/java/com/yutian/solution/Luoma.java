/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.solution;

import org.junit.Test;

/**
 * @author wengyz
 * @version Luoma.java, v 0.1 2020-02-19 23:22
 */
public class Luoma {

    /**
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int pre = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (pre < curr) {
                sum -= pre;
            } else {
                sum += pre;
            }
            pre = curr;
        }
        sum += pre;
        return sum;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    @Test
    public void test() {
        String s = "IVII";
        System.out.println(romanToInt(s));
    }
}
