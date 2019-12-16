/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;


/**
 * @author wengyz
 * @version MiddleNum.java, v 0.1 2019-12-13 10:59
 */
public class MiddleNum {

    /*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:

    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5

    */

    /**
     * 复杂度是O(log n) 肯定是二分查找了
     */

    @Test
    public void test() {

        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {3, 4};
        float v = middleNum(arr1, arr2);
        System.out.println(v);
    }

    /**
     * 求两个有序数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private float middleNum(Integer[] nums1, Integer[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;

        return 1;
    }
}
