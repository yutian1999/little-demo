/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.bbt;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author wengyz
 * @version StringDemo.java, v 0.1 2020-02-06 22:49
 */
public class StringDemo {

    @Test
    public void testWord() {
        String s = "i love china,i love coding. love love love";
        String word = manyWords(s);
        System.out.println(word);
    }

    @Test
    public void testCharacter() {
        String s = "i love china,i love coding.";
        String word = manyCharacter(s);
        System.out.println(word);
    }

    /**
     * 求句子中出现频率最高单词 空间复杂度 n 时间复杂度 n
     *
     * @param str
     * @return
     */
    private String manyWords(String str) {
        String[] arr = str.split("\\W");
        return getString(arr);
    }


    /**
     * 求句子中出现频率最高字母 空间复杂度 n 时间复杂度 n
     *
     * @param str
     * @return
     */
    private String manyCharacter(String str) {
        str = str.replaceAll("\\W", "");
        String[] arr = str.split("");
        return getString(arr);
    }

    /**
     * 查询高频核心方法
     *
     * @param arr
     * @return
     */
    private String getString(String[] arr) {
        if (arr.length == 0) {
            return "";
        }

        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list.get(0).getKey();
    }
}
