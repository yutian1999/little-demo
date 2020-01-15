/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import com.oracle.tools.packager.IOUtils;

import java.io.File;

/**
 * @author wengyz
 * @version FileThread.java, v 0.1 2020-01-09 15:09
 */
public class FileThread extends Thread {

    private final static String PATH = "/Users/wengyuzhu/Desktop/check-order/";

    private File file;

    private String name;

    public FileThread(File file, String name) {
        this.file = file;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            IOUtils.copyFile(file, new File(PATH + name));
//           IOUtils.deleteRecursive(new File(PATH + name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
