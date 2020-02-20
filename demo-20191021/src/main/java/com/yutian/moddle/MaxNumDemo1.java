/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version MaxNumDemo1.java, v 0.1 2020-02-19 10:44
 */
public class MaxNumDemo1 {
//
//    峰值元素是指其值大于左右相邻值的元素。
//
//    给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
//
//    数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
//
//    你可以假设 nums[-1] = nums[n] = -∞。
//
//    示例 1:
//
//    输入: nums = [1,2,3,1]
//    输出: 2
//    解释: 3 是峰值元素，你的函数应该返回其索引 2。
//    示例 2:
//
//    输入: nums = [1,2,1,3,5,6,4]
//    输出: 1 或 5
//    解释: 你的函数可以返回索引 1，其峰值元素为 2；
//                 或者返回索引 5， 其峰值元素为 6。

    /**
     * 时间复杂度O（n）
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }

    /**
     * 双指针 效率提升一倍？
     *
     * @param nums
     * @return
     */
    public int findPeakElement22(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int i = 1;
        int j = nums.length - 1;
        while (i < nums.length - 1 && j > 0) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }

            if (nums[j] > nums[j - 1] && nums[j] > nums[j + 1]) {
                return j;
            }
            i++;
            j--;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findPeakElement11(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 1};
        int peakElement = findPeakElement11(arr);
        System.out.println(peakElement);
    }
}
