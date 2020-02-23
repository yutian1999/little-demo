/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.classical;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wengyz
 * @version createUniqeuNo.java, v 0.1 2020-02-23 14:06
 */
public class createUniqeuNo {

    private static Long lasttime = -1L;
    private static Integer sequence = 0;
    private static Integer sequeBit = 5;

    /**
     * 15位毫秒级时间 序列号 本机ip末尾网段 12位随机数 1位后缀标示  15 + 3 + 5 + 1 = 24
     * 当前问题
     * 每秒单台机器最多生成10000个订单号
     *
     * @return
     */
    public static synchronized String createOrderSn() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmsss");
        String timeStr = format.format(date);
        long curr = System.currentTimeMillis() / 1000;
        if (curr == lasttime) {
            // 当前毫秒
            sequence++;
        } else {
            sequence = 0;
        }
        lasttime = curr;
        String orderSn = null;
        try {
            orderSn = timeStr + intToString(sequence) + getLocalIpEnd() + "S";
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException("生成订单号异常");
        }
        return orderSn;
    }

    /**
     * 获取机器最后一个网段，也可以根据ip转化成节点编号
     *
     * @return
     * @throws UnknownHostException
     */
    private static String getLocalIpEnd() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        //获得本机Ip
        String ip = inetAddress.getHostAddress().toString();
        return ip.substring(ip.lastIndexOf(".") + 1, ip.length());
    }

    /**
     * 保持序列号位数相等
     *
     * @param n
     * @return
     */
    private static String intToString(int n) {
        String s = String.valueOf(n);
        String prefix = "";
        if (s.length() < sequeBit) {
            for (int i = 0; i < 5 - s.length(); i++) {
                prefix += 0;
            }
        }
        return prefix + s;
    }


    public static void main(String[] args) throws UnknownHostException {


        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(createOrderSn());
                    }
                }
            });
            thread.start();
        }
    }


    @Test
    public void testCreateOrderSn() {

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10000; i++) {
            System.out.println(createOrderSn());
        }
        System.out.println(System.currentTimeMillis());

    }


    @Test
    public void test() throws UnknownHostException {
        System.out.println(getLocalIpEnd());

    }

    @Test
    public void test1() {
        for (int i = 0; i < 10001; i++) {
            System.out.println(intToString(i));
        }
    }


}
