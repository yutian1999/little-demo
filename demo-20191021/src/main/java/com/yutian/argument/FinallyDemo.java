/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

/**
 * @author wengyz
 * @version FinallyDemo.java, v 0.1 2019-12-19 15:44
 */
public class FinallyDemo {


    @Test
    public void test() {
        int deal = deal();
        System.out.println("deal return ====== rnum:" + deal);
    }


    private int deal() {

        int num = 1;

        try {
            System.out.println("try ====== tnum:" + num);
            int a = 1 / 0;
            return num;
        } catch (Exception e) {
            num++;
            System.out.println("catch ======= cnum:" + num);
            return num;
        } finally {
            num = num + 10;
            System.out.println("finally ======= fnum:" + num);
        }
    }
}
