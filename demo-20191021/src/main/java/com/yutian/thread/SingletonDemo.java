/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.thread;

import java.util.stream.IntStream;

/**
 * @author wengyz
 * @version SingletonDemo.java, v 0.1 2020-04-08 22:31
 */
public class SingletonDemo {

    private static class ClassHolder {
        private static SingletonDemo instance = new SingletonDemo();
    }

    public static SingletonDemo instance() {
        return ClassHolder.instance;
    }

    private SingletonDemo() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        student = new Student();
    }

    private Student student;

    private static volatile SingletonDemo instance;

    public static SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    /**
     * Getter method for property <tt>student</tt>.
     *
     * @return property value of student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Setter method for property <tt>student</tt>.
     *
     * @param student value to be assigned to property student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    public static void main(String[] args) {
        IntStream.range(0, 1000).forEach(r -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingletonDemo instance = SingletonDemo.getInstance();
                    System.out.println(instance.getStudent().getName() + "  " + instance.getStudent().getAge());
                }
            }).start();
        });
    }


    // 1.分配内存 memory = allocate()
    // 2.初始化对象 instance（memory）
    // 3. instace = memory
    // 2和3指令重排序
}
