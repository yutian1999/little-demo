/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * nio tcp server
 *
 * @author wengyz
 * @version NioReceiveServer.java, v 0.1 2020-01-14 10:05
 */
public class NioReceiveServer {

    static class Client {
        // 文件名称
        String fileName;
        // 文件长度
        long length;
        // 文件开始传输时间
        long startTime;
        // 客户端地址
        InetSocketAddress remoteAddress;
        // 文件输出通道
        FileChannel fileChannel;
    }

    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    private Charset charset = Charset.forName("UTF-8");

    Map<SelectableChannel, Client> clientMap = new HashMap<SelectableChannel, Client>();

    private static final String DESC_PATH = "/Users/wengyuzhu/Desktop/demo";

    public void startServer() throws IOException {
        // 1.获取选择器
        Selector selector = Selector.open();
        // 2.获取socket通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 3.获取socket
        ServerSocket socket = socketChannel.socket();
        // 4.通道设置非阻塞
        socketChannel.configureBlocking(false);
        // 5.端口绑定
        socket.bind(new InetSocketAddress(18888));
        // 6.将通道注册到选择器上
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("=========Server start=========");
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    if (channel == null) {
                        continue;
                    }
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    // 初始化客户端
                    Client client = new Client();
                    client.remoteAddress = (InetSocketAddress) channel.getRemoteAddress();
                    clientMap.put(channel, client);
                    System.out.println("=========Client connect=========");
                } else if (key.isReadable()) {
                    System.out.println("=========Client write=========");
                    processData(key);
                }
                it.remove();
            }
        }
    }

    private void processData(SelectionKey key) {
        Client client = clientMap.get(key.channel());
        SocketChannel channel = (SocketChannel) key.channel();
        int length = -1;
        try {
            //
            buffer.clear();
            while ((length = channel.read(buffer)) > 0) {
                buffer.flip();
                if (client.fileName == null) {
                    String fileName = "1.txt";
                    System.out.println("文件名称：" + fileName);
                    File descPath = new File(DESC_PATH);
                    if (!descPath.exists()) {
                        descPath.mkdir();
                    }
                    String fullName = descPath.getAbsolutePath() + File.separator + fileName;
                    File file = new File(fullName);
                    FileChannel fileChannel = new FileOutputStream(file).getChannel();
                    client.fileChannel = fileChannel;
                    client.fileName = fileName;
                    System.out.println("文件名称：" + fileName);
                } else if (client.length == 0) {
                    long longa = buffer.getLong();
                    client.length = longa;
                    client.startTime = System.currentTimeMillis();
                    System.out.println("文件大小：" + longa);
                } else {
                    // 文件内容
                    client.fileChannel.write(buffer);
                    System.out.println("接收文件内容:" + length);
                }
                buffer.clear();
            }
            client.fileChannel.force(true);


            if (length == -1) {
                // 传输完毕
                channel.close();
                client.fileChannel.close();
                key.cancel();
                System.out.println("========上传完毕========");
                System.out.println("======文件名称：" + client.fileName);
                System.out.println("======文件大小：" + client.length);
            }

        } catch (Exception e) {
            key.cancel();
            System.out.println("服务器异常：error = " + e.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        NioReceiveServer server = new NioReceiveServer();
        server.startServer();
    }
}
