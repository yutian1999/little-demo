/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.nio;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wengyz
 * @version NioFileCopy.java, v 0.1 2020-01-13 11:06
 */
public class NioFileCopy {

    private static final String SRC = "/Users/wengyuzhu/Desktop/JAVA并发编程实战.pdf";
    private static final String DESC = "/Users/wengyuzhu/Desktop/copy.pdf";


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
//        fileCopy(SRC,DESC);
        fastFileCopy(SRC, DESC);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "毫秒");
    }

    /**
     * 文件拷贝
     *
     * @param src
     * @param desc
     */
    private static void fileCopy(String src, String desc) {

        File srcFile = new File(src);
        File descFile = new File(desc);


        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            // 定义一个buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int length = -1;
            while ((length = inChannel.read(buffer)) != -1) {
                // 此时将buffer转为可读 outChannel 读取buffer并写出去
                System.out.println("读入字节：" + length);
                buffer.flip();
                int outLength = 0;
                while ((outLength = outChannel.write(buffer)) != 0) {
                    System.out.println("写入字节：" + outLength);
                }
                buffer.clear();
            }
            outChannel.force(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            close(fis);
            close(fos);
            close(inChannel);
            close(outChannel);
        }
    }

    /**
     * 文件快熟拷贝
     *
     * @param src
     * @param desc
     */
    private static void fastFileCopy(String src, String desc) {

        File srcFile = new File(src);
        File descFile = new File(desc);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            long size = inChannel.size();
            long pos = 0;
            long count = 0;
            while (pos < size) {
                count = size - pos > 1024 ? 1024 : size - pos;
                pos += outChannel.transferFrom(inChannel, pos, count);
            }
            outChannel.force(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            close(fis);
            close(fos);
            close(inChannel);
            close(outChannel);
        }
    }

    private static void close(Closeable o) {
        if (o == null) {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
