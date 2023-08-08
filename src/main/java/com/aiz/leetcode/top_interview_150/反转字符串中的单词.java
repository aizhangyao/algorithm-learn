package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author ZhangYao
 * @className 反转字符串中的单词
 * @description https://leetcode.cn/problems/reverse-words-in-a-string/
 * @date Create in 16:29 2023/8/8
 */
public class 反转字符串中的单词 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        String[] strs = s.split(" ");
        for (int i = strs.length - 1; i > 0; i--) {
            if (!Objects.equals(strs[i], "")) {
                stringBuilder.append(strs[i].trim());
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append(strs[0].trim());
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        反转字符串中的单词 clazz = new 反转字符串中的单词();
        String s = clazz.reverseWords("the sky is blue");
        assert Objects.equals(s, "blue is sky the");
    }

    @Test
    public void test2() {
        反转字符串中的单词 clazz = new 反转字符串中的单词();
        String s = clazz.reverseWords("  hello world  ");
        assert Objects.equals(s, "world hello");
    }

    @Test
    public void test3() {
        反转字符串中的单词 clazz = new 反转字符串中的单词();
        String s = clazz.reverseWords("a good   example");
        assert Objects.equals(s, "example good a");
    }
}
