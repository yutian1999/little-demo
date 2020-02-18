/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version DPDemo1.java, v 0.1 2020-02-17 19:50
 */
public class DPDemo1 {

    /*
    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

    示例 1:

    输入: [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。

    */

    // 分析 动态规划

    /**
     * 动态方程 f(x) = max (f(x - 1),x)
     */

    /**
     * 求非负集合的最大连续积序列
     *
     * @param arr
     * @return
     */
    public double maxNoLessZero(double[] arr) {

        double currMax = 0;
        double max = 0;

        for (int i = 0; i < arr.length; i++) {
            currMax = Math.max(currMax * arr[i], arr[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    /**
     * 求最大序列的积
     *
     * @param arr
     * @return
     */
    public int max(int[] arr) {

        int max = Integer.MIN_VALUE;
        int currMax = 1;
        int currMin = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = currMin;
                currMin = currMax;
                currMax = temp;
            }

            currMax = Math.max(currMax * arr[i], arr[i]);
            currMin = Math.min(currMin * arr[i], arr[i]);
            max = Math.max(currMax, max);
        }

        return max;
    }

    @Test
    public void test() {
        int[] arr = {-1, -2, 0, -1, 3};
        System.out.println(max(arr));
    }

    @Test
    public void testNoLessZero() {
        double[] arr = {3, 2, 0.1, 4, 2, 0.3};
        double v = maxNoLessZero(arr);
        System.out.println(v);
    }

}
