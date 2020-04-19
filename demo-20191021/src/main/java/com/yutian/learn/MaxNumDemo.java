/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.learn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wengyz
 * @version MaxNumDemo.java, v 0.1 2020-02-06 23:33
 */
public class MaxNumDemo implements Comparator<String> {

    @Test
    public void test() {
        int[] arr = {23, 2, 3, 6, 43, 45, 6, 9};
        long maxNum = maxNum(arr);
        System.out.println(maxNum);
    }


    /**
     * 将一个数组里的数 组成最大数，例如【23，2，3，6，43，45，6，9】
     *
     * @param arr
     * @return
     */
    private long getMaxNum(int[] arr) {

        String[] strArr = new String[arr.length];
        // 将数组转换成字符串数组
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(strArr, new MaxNumDemo());

        String res = "";
        for (int i = 0; i < arr.length; i++) {
            res += strArr[i];
        }


        return Long.valueOf(res);
    }

    @Override
    public int compare(String o1, String o2) {
        String a = o1 + o2;
        String b = o2 + o1;
        return b.compareTo(a);
    }


    public long maxNum(int[] arr) {
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(str, new MyComparator());

        String re = "";
        for (int i = 0; i < str.length; i++) {
            re += str[i];
        }
        return Long.valueOf(re);
    }

    class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String a = o1 + o2;
            String b = o2 + o1;

            return b.compareTo(a);
        }
    }

}
