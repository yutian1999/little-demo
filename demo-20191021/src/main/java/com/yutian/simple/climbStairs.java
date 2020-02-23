/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

/**
 * @author wengyz
 * @version climbStairs.java, v 0.1 2020-02-20 20:46
 */
public class climbStairs {


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * 注意：给定 n 是一个正整数。
     *
     * n-1 n 2
     *  f(3) = f(2) + 2;
     *  f(3) = f(1) + 2 + 2;
     *  f(3) = f(n-3) + 2 + 2 +2;
     *
     *
     *  f(n) = f(n - 2) + 2;
     *
     *    1 2  6  11  20
     *
     *
     *
     *
     * *       f(7) = f(5 - 2) + 2;
     *         f(7) = f(7 - 4) + 2 + 2;
     *         f(7) = f(7 - 6) + 2 + 2 + 2;
     *
     *         f(0) = 0;
     *         f(1) = 1;
     *         f(2) = 2;
     *         f(3) = 3;
     *         f(4) = 5;
     */

    /**
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Test
    public void test() {
        int i = climbStairs(4);
        System.out.println(i);
    }

//    数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//
//    每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//
//    您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
//
//    示例 1:
//
//    输入: cost = [10, 15, 20]
//    输出: 15
//    解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
//             示例 2:
//
//    输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//    输出: 6
//    解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
//    注意：
//
//    cost 的长度将会在 [2, 1000]。
//    每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。

    /**
     * 最小费力
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int f0 = 0, f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

}
