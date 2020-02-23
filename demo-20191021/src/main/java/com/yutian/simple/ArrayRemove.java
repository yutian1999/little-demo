/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wengyz
 * @version ArrayRemove.java, v 0.1 2020-02-20 14:02
 */
public class ArrayRemove {

    /**
     * 原地移除数组的元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                    }
                }
                length--;
            }
        }
        return length;
    }

    /**
     * 双指针原地删除
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement222(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 4, 4, 5};
        System.out.println(removeElement222(arr, 4));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 查找数组内的元素下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void testFind() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(search(arr, 3));
    }

    /**
     * 寻找数组的中心索引
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int leftSum = 0, sum = 0;
        for (int x : nums) sum += x;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }


    @Test
    public void testPivotIndex() {
        int[] arr = {1, 3, 4, 4, 2, 6};
        System.out.println(pivotIndex(arr));
    }

    /**
     * 自除数
     *
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            if (isSelfDividingNumbers(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isSelfDividingNumbers(int num) {
        int or = num;
        while (or / 10 > 0) {
            Integer f = or % 10;
            if (f == 0) {
                return false;
            }
            or = or / 10;
            if (num % f != 0) {
                return false;
            }
        }

        if (num % or != 0) {
            return false;
        }
        return true;
    }


    /**
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {

        int index = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                index = i + 1;
            }
        }
        return index;
    }
}
