/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wengyz
 * @version IsHappy.java, v 0.1 2020-02-20 19:20
 */
public class IsHappy {

    /**
     * 判断一个数是否是快乐数
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int l = 0;
            while (n / 10 > 0) {
                int p = n % 10;
                l += p * p;
                n = n / 10;
            }
            l += n * n;

            if (l == 1) {
                return true;
            } else {
                n = l;
                if (!set.add(l)) {
                    return false;
                }
            }
        }
    }

    @Test
    public void test() {
        System.out.println(isHappy(21));
    }

    public boolean isUgly(int num) {
        while ((num % 2 == 0) || (num % 3 == 0) || (num % 5 == 0)) {
            if (num % 2 == 0) {
                num = num / 2;
            }

            if (num % 3 == 0) {
                num = num / 3;
            }

            if (num % 5 == 0) {
                num = num / 5;
            }

        }

        if (num == 2) {
            return true;
        }

        if (num == 3) {
            return true;
        }

        if (num == 5) {
            return true;
        }
        return false;
    }

    @Test
    public void testUgly() {
        System.out.println(isHappy(14));
    }

}
