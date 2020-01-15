/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.nio;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * @author wengyz
 * @version NioDemo.java, v 0.1 2020-01-13 10:05
 */
public class BufferDemo {

    @Test
    public void test1() throws UnsupportedEncodingException {
        // 初始化buffer 默认写状态
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put("iloveyou".getBytes());

        // 转成读状态
        buffer.flip();
        int limit = buffer.limit();
        byte[] bytes = new byte[limit];
        for (int i = 0; i < limit; i++) {
            bytes[i] = buffer.get();
        }

        String s = new String(bytes, "UTF-8");
        System.out.println(s);

        System.out.println("=========再次读===============");
        // 必须重置postion位置
        buffer.rewind();
        byte[] bs = new byte[limit];
        for (int i = 0; i < limit; i++) {
            bs[i] = buffer.get();
        }

        String ss = new String(bs, "UTF-8");
        System.out.println(ss);

        // 清楚postion 转为可写
        buffer.clear();

        buffer.put("IMissYou".getBytes());

    }
}
