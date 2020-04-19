/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wengyz
 * @version ArrayDemo.java, v 0.1 2020-02-25 11:00
 */
public class ArrayDemo {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        if (set1.size() > set2.size()) {
            return interSelect(set1, set2);
        }
        return interSelect(set2, set1);
    }

    private int[] interSelect(Set<Integer> set1, Set<Integer> set2) {
        int[] arr = new int[set1.size()];
        int index = 0;
        for (int num : set1) {
            if (set2.contains(num)) {
                arr[index] = num;
                index++;
            }
        }

        return Arrays.copyOf(arr, index);
    }

    public int rob(int[] nums) {
        int preMax = 0;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(preMax + nums[i], currMax);
            preMax = temp;
        }
        return currMax;
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 2, 4, 3, 4};
        System.out.println(rob(arr));
    }

}
