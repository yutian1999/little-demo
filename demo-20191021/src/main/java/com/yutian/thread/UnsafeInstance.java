/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wengyz
 * @version UnsafeInstance.java, v 0.1 2020-03-07 20:51
 */
public class UnsafeInstance {

    public static Unsafe getInstance() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
