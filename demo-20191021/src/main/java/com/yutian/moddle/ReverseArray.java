/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version ReverseArray.java, v 0.1 2020-02-18 10:42
 */
public class ReverseArray {

//    153
//    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//            ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//    请找出其中最小的元素。
//
//    你可以假设数组中不存在重复元素。
//
//    示例 1:
//
//    输入: [3,4,5,1,2]
//    输出: 1
//    示例 2:
//
//    输入: [4,5,6,7,0,1,2]
//    输出: 0


    /**
     * 求升序数组旋转后的最小值  排序求解
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - i; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums[0];
    }

    /**
     *
     * @param nums
     * @return
     */
    public int findMinByDP(int[] nums) {
        int iMin = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            iMin = Math.min(iMin, nums[i]);
            min = Math.min(iMin, min);
        }
        return min;
    }

    /**
     * 以上两种解 都没有依据数组的旋转
     * [1，2，3，4，5，6，7]
     * nums[leng - 1] > nums[0]说明数组没有旋转 最小值nums[0]
     * <p>
     * 否则说明数组旋转了
     * [5,6,7,1,2,3,4]
     * 取 mid = nums[leng / 2]
     * <p>
     * if mid < nums[0]  最小值再右半部
     */

    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public int findMinByBinary(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    // 我们先来简化这道题 通过二分查找 找寻有序数组的指定值的位置
    public int indexOf(int[] arr, int value) {
        int left = 0;
        int right = arr.length;
        int mid = (left + right) / 2;

        while (left <= right) {

            if (value == arr[mid]) {
                return mid;
            }

            if (arr[mid] < value) {
                left = mid + 1;
            }

            if (arr[mid] > value) {
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 4, 5, 6, 8};
        int i = indexOf(arr, 5);
        System.out.println(i);
    }


    @Test
    public void testMin() {
        int[] arr = {2, 3, 4, 5, 1};
        System.out.println(findMinByBinary(arr));
    }

}
