/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.bbt;

import org.junit.Test;

/**
 * @author wengyz
 * @version IsZhi.java, v 0.1 2020-02-06 17:29
 */
public class IsZhi {

    @Test
    public void test() {
        boolean primeNum = isPrimeNum(19);
        System.out.println(primeNum);
    }

    /**
     * 判断是否是质数
     *
     * @param num
     * @return
     */
    private boolean isPrimeNum(int num) {

        if (num <= 2) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
