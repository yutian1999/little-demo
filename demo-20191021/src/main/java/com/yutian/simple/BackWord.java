/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

/**
 * @author wengyz
 * @version BackWord.java, v 0.1 2019-12-27 11:45
 */
public class BackWord {

//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    @Test
    public void test() {
        boolean backIntBetter = isBackIntBest(212);
        System.out.println(backIntBetter);
    }


    /**
     * 利用字符串api
     *
     * @param x
     * @return
     */
    private boolean isBackInt(int x) {
        String source = new String(x + "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(x);
        String r = stringBuffer.reverse().toString();
        return source.equals(r);
    }


    /**
     * 对10取膜计算新的数，如果与原数相同即是回文数
     *
     * @param x
     * @return
     */
    private boolean isBackIntBetter(int x) {

        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int source = x;
        StringBuilder sb = new StringBuilder();
        int mold = 0;
        while (x > 0) {
            mold = x % 10;
            sb.append(mold);
            x = x / 10;
        }

        Long back = Long.valueOf(sb.toString());
        return source == back;
    }


    /**
     * @param x
     * @return
     */
    private boolean isBackIntBest(int x) {

        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }
        int source = x;
        int reverse = 0;
        int mold = 0;
        while (x > 0) {
            mold = x % 10;
            x = x / 10;
            reverse = reverse * 10 + mold;
        }

        return reverse == source;
    }

}
