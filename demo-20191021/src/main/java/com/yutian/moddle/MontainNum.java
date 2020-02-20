/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version MontainNum.java, v 0.1 2020-02-19 11:44
 */
public class MontainNum {

//    我们把符合下列属性的数组 A 称作山脉：
//
//    A.length >= 3
//    存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//    给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
//
//             
//
//    示例 1：
//
//    输入：[0,1,0]
//    输出：1
//    示例 2：
//
//    输入：[0,2,1,0]
//    输出：1
//


    // 山脉数组 先升后降
    // 这道题有至少有三种做法  排序  逐个比较
    // 1 2 3 4 5 4 3 2 1


    /**
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] > A[mid + 1]) {
                // 峰值在左边
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
