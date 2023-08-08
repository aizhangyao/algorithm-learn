package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 找出字符串中第一个匹配项的下标
 * @description https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @date Create in 19:01 2023/8/8
 */
public class 找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        for (int i = 0; i <= hChars.length - nChars.length; i++) {
            int hIndex = i;
            int nIndex = 0;
            while (nIndex < nChars.length && hChars[hIndex++] == nChars[nIndex++]) {
                if (nIndex == nChars.length) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        找出字符串中第一个匹配项的下标 clazz = new 找出字符串中第一个匹配项的下标();
        int i = clazz.strStr("sadbutsad", "sad");
        assert i == 0;
    }

    @Test
    public void test2() {
        找出字符串中第一个匹配项的下标 clazz = new 找出字符串中第一个匹配项的下标();
        int i = clazz.strStr("leetcode", "leeto");
        assert i == -1;
    }

    @Test
    public void test3() {
        找出字符串中第一个匹配项的下标 clazz = new 找出字符串中第一个匹配项的下标();
        int i = clazz.strStr("a", "a");
        assert i == 0;
    }
}
