/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

/**
 * @author wengyz
 * @version Robber.java, v 0.1 2019-12-18 17:59
 */
public class Robber {

//    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
//    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
//    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
//    示例 1:
//
//    输入: [1,2,3,1]
//    输出: 4
//    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//                 偷窃到的最高金额 = 1 + 3 = 4 。
//    示例 2:
//
//    输入: [2,7,9,3,1,5]
//    输出: 12
//    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//                 偷窃到的最高金额 = 2 + 9 + 1 = 12 。


    // 分析：动态规划方程 dp[n] = max(dp[n -1],dp[n-2] + num[n]);
    //

    @Test
    public void test() {
        int[] arr = {2, 1, 1, 2};
        int i = moreMoney(arr);
        System.out.println(i);
    }

    /**
     * 打家劫舍问题
     *
     * @param nums
     * @return
     */
    private int moreMoney(int[] nums) {

        int leng = nums.length;

        if (leng == 0) {
            return 0;
        }

        if (leng == 1) {
            return nums[0];
        }

        if (leng == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[leng + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= leng; i++) {
            // 比较前一个的和 前二个和加前一个  放进动态数组里
            // 需要注意下 dp数组相对于nums数组索引后移了一个 因为dp[0]填充了0
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[leng];
    }

}
