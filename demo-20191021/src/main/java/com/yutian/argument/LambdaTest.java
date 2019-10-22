/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

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
}