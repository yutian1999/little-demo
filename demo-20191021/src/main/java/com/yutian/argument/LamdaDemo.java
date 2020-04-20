/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.argument;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wengyz
 * @version LamdaDemo.java, v 0.1 2020-04-20 23:21
 */
public class LamdaDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setAge(18);
        s1.setName("lili");

        Student s2 = new Student();
        s2.setAge(18);
        s2.setName("rose");

        list.add(s1);
        list.add(s2);

//        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Student::getAge, Student::getName));

//        Map<Integer, List<Student>> collect = list.stream().collect(Collectors.groupingBy(Student::getAge));

        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(Student::getAge,
                Collectors.mapping(Student::getName, Collectors.toList())));


        System.out.println(collect);

    }
}
