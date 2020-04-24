/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.demo;

import com.yutian.argument.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wengyz
 * @version ReferenceDemo.java, v 0.1 2020-04-24 23:57
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        Student s1 = new Student();
        s1.setName("lili");

        Student s2 = new Student();
        s2.setName("rose");

        list.add(s1);
        list.add(s2);

        for (Student student : list) {
            if (student.getName().equals("lili")) {
                student.setName("djb");
            }

        }

        // map 映射

        System.out.println(list);

        List<String> collect = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(collect);

        Map<Integer, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(collect1);


    }
}
