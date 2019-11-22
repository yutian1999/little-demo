/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author wangyz
 * @version SuanFa.java, v 0.1 2019-11-22 14:48
 */
public class SuanFa {
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    @Test
    public void test(){
        int [] nums = {3,2,4,5,6,7,2,1};
        int target = 6;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] twoSumWithMap(int[] nums,int target){
        int[] indexs = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        return indexs;
    }

    public int [] twoSum(int[] nums,int target){
        int [] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            // 减少内层循环
            for (int j = i+1; j < nums.length; j++) {
                if (another == nums[j]) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }
}