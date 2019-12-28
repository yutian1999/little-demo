/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

/**
 * @author wengyz
 * @version DpTest.java, v 0.1 2019-12-18 09:26
 */
public class DpTest {

//    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    示例:
//
//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//    进阶:
//
//    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。


    /**
     * 分析：这道题是寻找最优子序列的，可以想到使用动态规划
     * n = 0 ; max = f(0);
     * n = 1 ; max(f(1),arr(1))   此时可以取第一个和第二个数的和，也可以取第二个，当第一个数小于0的时候
     * n = 2 ; max(f(2),arr(2))
     */


    /**
     * 最大子数组的值
     *
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {

        // 最大子串和
        int max = nums[0];

        // 当前最大
        int currMax = nums[0];

        for (int i = 0; i < nums.length; i++) {
            // 计算出当前最大和
            currMax = Math.max(currMax + nums[i], nums[i]);
            // 比较出当前之前的最大和
            max = Math.max(max, currMax);
        }

        return max;
    }

}
