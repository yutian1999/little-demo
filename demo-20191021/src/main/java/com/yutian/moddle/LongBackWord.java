/**
 * fshows.com
 * Copyright (C) 2013-2019 All Rights Reserved.
 */
package com.yutian.moddle;

import org.junit.Test;

/**
 * @author wengyz
 * @version LongBackWord.java, v 0.1 2019-12-27 14:36
 */
public class LongBackWord {
    //    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    @Test
    public void test() {
        String s = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
//        System.out.println(s.length());
//        String s = "ba";
        String longBackWord = getLongBackWordBetter(s);
        System.out.println(longBackWord);
    }

    /**
     * xrcrx
     * 每个字符向后查找判断是否是回文
     * 时间复杂度 O（n2）
     *
     * @param s
     * @return
     */
    private String getLongBackWord(String s) {
        int length = s.length();
        int backWordLength = 0;
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j <= length; j++) {
                StringBuilder sb = new StringBuilder();
                String substr = s.substring(i, j);
                String reverse = sb.append(substr).reverse().toString();
                if (substr.equals(reverse)) {
                    backWordLength = j - i;
                    if (backWordLength > max) {
                        max = backWordLength;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end);
    }


    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    private String getLongBackWordBetter(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        boolean[][] dp = new boolean[length][length];
        String str = "";
        for (int i = length - 1; i > 0; i--) {
            for (int j = i; j < length; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && ((j - i < 2) || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > str.length()) {
                    str = s.substring(i, j + 1);
                }
            }
        }
        return str;
    }
}
