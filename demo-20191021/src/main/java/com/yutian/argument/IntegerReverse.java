/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

/**
 * @author wengyz
 * @version IntegerReverse.java, v 0.1 2019-12-17 22:03
 */
public class IntegerReverse {

//    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
//    示例 1:
//
//    输入: 123
//    输出: 321
//             示例 2:
//
//    输入: -123
//    输出: -321
//    示例 3:
//
//    输入: 120
//    输出: 21
//    注意:
//
//    假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

    @Test
    public void test1() {
        double pow = Math.pow(2, 31);
        System.out.println(pow);
    }

    @Test
    public void test() {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    private int reverse(int x) {

        long result = 0;

        while (x != 0) {
            int i = x % 10;
            result = result * 10 + i;
            x = x / 10;
        }

        if (result > Math.pow(2, 31) - 1 || result < -Math.pow(2, 31)) {
            return 0;
        }

        return (int) result;
    }

}
