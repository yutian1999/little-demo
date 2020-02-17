/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wengyz
 * @version ArrayRotate.java, v 0.1 2020-02-16 19:24
 */
public class ArrayRotate {

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(arr, 8);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  1 2 3 4    1
     *  4 1 2 3
     */

    /**
     * 数组旋转
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                arr[i] = nums[nums.length - k + i];
            } else {
                arr[i] = nums[i - k];
            }

        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
