/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yutian.spi;

import java.util.HashSet;
import java.util.ServiceLoader;
import java.util.Set;

/**
 * @author wengyz
 * @version Test.java, v 0.1 2020-03-03 16:17
 */
public class Test {

    public static void main(String[] args) {
        ServiceLoader<HuMan> loader = ServiceLoader.load(HuMan.class);
        System.out.println("spi");
        loader.forEach(HuMan::sayHello);
    }


    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() > 1 ? false : true;
    }


    @org.junit.Test
    public void test() {
        String s = "12";
        System.out.println(canPermutePalindrome(s));
    }
}
