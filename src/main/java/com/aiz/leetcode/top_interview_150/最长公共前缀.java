package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author ZhangYao
 * @className 最长公共前缀
 * @description https://leetcode.cn/problems/longest-common-prefix/
 * @date Create in 16:02 2023/8/8
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int length = 0;
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int i = 0; i < minLen; i++) {
            String str = strs[0];
            for (int j = 1; j < strs.length; j++) {
                if (str.charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, length);
                }
            }
            length++;
        }
        return strs[0].substring(0, length);
    }

    @Test
    public void test() {
        最长公共前缀 clazz = new 最长公共前缀();
        String[] strs = new String[]{"flower", "flow", "flight"};
        String s = clazz.longestCommonPrefix(strs);
        assert Objects.equals(s, "fl");
    }

    @Test
    public void test2() {
        最长公共前缀 clazz = new 最长公共前缀();
        String[] strs = new String[]{"dog", "racecar", "car"};
        String s = clazz.longestCommonPrefix(strs);
        assert Objects.equals(s, "");
    }

    @Test
    public void test3() {
        最长公共前缀 clazz = new 最长公共前缀();
        String[] strs = new String[]{""};
        String s = clazz.longestCommonPrefix(strs);
        assert Objects.equals(s, "");
    }

    @Test
    public void test4() {
        最长公共前缀 clazz = new 最长公共前缀();
        String[] strs = new String[]{"", "b"};
        String s = clazz.longestCommonPrefix(strs);
        assert Objects.equals(s, "");
    }
}
