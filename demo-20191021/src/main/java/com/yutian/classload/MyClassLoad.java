/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.classload;

/**
 * @author wengyz
 * @version MyClassLoad.java, v 0.1 2020-02-01 14:27
 */
public class MyClassLoad extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClasss run");
        return super.findClass(name);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("loadClass run");
        return super.loadClass(name, resolve);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoad classLoad = new MyClassLoad();
        classLoad.loadClass("/Users/wengyuzhu/workspace/little-demo/demo-20191021/target/classes/com/yutian/moddle/LongBackWord.class");
//        classLoad.loadClass("com.yutian.moddle.LongBackWord",true);

    }
}
