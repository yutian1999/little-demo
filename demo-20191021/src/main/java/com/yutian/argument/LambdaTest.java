/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.DoubleToIntFunction;

/**
 *
 * @author wangyz
 * @version LambdaTest.java, v 0.1 2019-10-22 11:43
 */
public class LambdaTest {

    @Test
    public void test() throws Exception {
        Callable<Integer> integerCallable = () -> 5;
        Integer call = integerCallable.call();
        System.out.println(call);
    }


    /**
     * 将大集合均匀切割成小集合
     */
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 358; i++) {
            list.add(i);
        }
        int size = list.size();
        int offset = 100;
        int start = 0;
        int end;

        while (true){
            end = start + offset;
            if (end > size){
                end = size;
            }
            List<Integer> subList = list.subList(start, end);
            System.out.println(subList);
            start += offset;
            if (start >= size){
                break;
            }
        }
    }

    /**
     * 测试字符串对象的创建
     * 第一种创建方式是先在栈内创建一个引用s1，然后去常量池找是否有"abc"字符串，如果有将s1指向"abc",如果没有则在常量池中创建字符串"abc"
     * 并将s1指向字符串"abc"，而s2对象并没有创建而是直接指向了s1，所以s2和s1是同一个对想
     *
     * 第二种方式是每一次都会创建一个对象
     *
     */
    @Test
    public void test3(){
        String s1 = "abc"; // 1
        String s2 ="abc";

        String s3 = new String("123"); // 2
        String s4 = new String("123");
        System.out.println(s1== s2);
        System.out.println(s3==s4);
    }
}