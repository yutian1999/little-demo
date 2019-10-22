/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.argument;

import org.junit.Test;

/**
 *
 * @author wangyz
 * @version ArgumentTest.java, v 0.1 2019-10-21 16:02
 */
public class ArgumentTest {

    /**
     * 基本类型测试
     */
    @Test
    public void baseTypeTest(){
        int a = 10;
        modify(a);
        System.out.println(a);
    }

    @Test
    public void refercenceTypeTest(){
        Student student = new Student();
        student.setAge(18);
        student.setName("yuanyuan");
        modify(student);
        System.out.println(student);
    }

    private void modify(Student studetn){
        studetn.setName("yutian");
    }


    private void modify(int a){
        a = 20;
    }
}