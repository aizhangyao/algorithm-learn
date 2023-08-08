package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @version 1.0
 * @className 最后一个单词的长度
 * @description https://leetcode.cn/problems/length-of-last-word/
 * @date Create in 15:46 2023/8/8
 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int right = length - 1;
        int left = -1;
        boolean hasChar = false;
        for (int i = length - 1; i >= 0; i--) {
            if (!hasChar && s.charAt(i) != ' ') {
                hasChar = true;
                right = i;
            }
            if (hasChar && s.charAt(i) == ' ') {
                left = i;
                break;
            }
        }
        return right - left;
    }

    @Test
    public void test() {
        最后一个单词的长度 clazz = new 最后一个单词的长度();
        int i = clazz.lengthOfLastWord("Hello World");
        assert i == 5;
    }

    @Test
    public void test2() {
        最后一个单词的长度 clazz = new 最后一个单词的长度();
        int i = clazz.lengthOfLastWord("   fly me   to   the moon  ");
        assert i == 4;
    }

    @Test
    public void test3() {
        最后一个单词的长度 clazz = new 最后一个单词的长度();
        int i = clazz.lengthOfLastWord("luffy is still joyboy");
        assert i == 6;
    }

    @Test
    public void test43() {
        最后一个单词的长度 clazz = new 最后一个单词的长度();
        int i = clazz.lengthOfLastWord(" a");
        assert i == 1;
    }
}
