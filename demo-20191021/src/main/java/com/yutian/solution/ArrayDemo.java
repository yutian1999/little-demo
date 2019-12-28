/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.solution;

import org.junit.Test;

/**
 * @author wengyz
 * @version ArrayDemo.java, v 0.1 2019-12-24 20:25
 */
public class ArrayDemo {

    /**
     *
     */
    @Test
    public void demo() {

        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        //0, 1, 1, 1, 2, 2, 3, 3, 4, 0
        //0, 1, 2, 2, 3, 3, 4, 0, 1, 1
        //0, 1, 2, 3, 3, 4, 0, 1, 1, 2
        //0, 1, 2, 3, 4, 0, 1, 1, 2, 3
        //0, 1, 2, 3, 4, 0, 1, 1, 2, 3

        int length = removeDupElementSort(arr);
        System.out.println(length);

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 原地删除数组中重复的元素
     *
     * @param nums
     * @return
     */
    private int removeDupElement(int[] nums) {

        int length = nums.length;
        int count = 0;
        int temp = 0;

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j < length - count; j++) {

                if (nums[j] == nums[i]) {
                    // 将arr[j]从后面开始往前交换位置
                    temp = nums[j];
                    nums[j] = nums[length - count - 1];
                    nums[length - count - 1] = temp;
                    count++;
                }
            }
        }

        return length - count;
    }


    /**
     * 原地删除数组中重复的元素
     *
     * @param nums
     * @return
     */
    private int removeDupElementSort(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
