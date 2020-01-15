/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.nio;

import java.io.File;
import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author wengyz
 * @version NioClient.java, v 0.1 2020-01-14 11:27
 */
public class NioClient {

    private static final String SRC = "/Users/wengyuzhu/Desktop/JAVA并发编程实战.pdf";

    private Charset charset = Charset.forName("UTF-8");

    private void sendFile() {
        try {
            File file = new File(SRC);
            if (!file.exists()) {
                System.out.println("文件不存在");
                return;
            }


            // 文件通道
            FileChannel fileChannel = new FileInputStream(file).getChannel();
            // socket连接
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.socket().connect(new InetSocketAddress("127.0.0.1", 18888));
            socketChannel.configureBlocking(false);
            System.out.println("开始连接服务器");
            // 自旋连接
            while (!socketChannel.finishConnect()) {

            }


            // 写出文件名
            ByteBuffer bf = charset.encode(file.getName());
            System.out.println(file.getName());
            bf.flip();
            socketChannel.write(bf);

            // 写出文件大小
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.putLong(file.length());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

            // 写出文件
            System.out.println("开始传输文件");
            int length = -1;
            long pos = 0;
            while ((length = fileChannel.read(buffer)) != -1) {
                buffer.flip();
                socketChannel.write(buffer);
                buffer.clear();
                pos += length;
                System.out.println("传输文件大小：" + pos);
            }

            fileChannel.close();
            socketChannel.shutdownInput();
            socketChannel.close();
            System.out.println("文件传输完成");

        } catch (Exception e) {
            System.out.println("文件传输失败");
        }
    }

    public static void main(String[] args) {
        NioClient client = new NioClient();
        client.sendFile();
    }
}
