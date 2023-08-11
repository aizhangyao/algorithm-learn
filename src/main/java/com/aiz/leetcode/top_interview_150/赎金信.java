package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 赎金信
 * @description https://leetcode.cn/problems/ransom-note/
 * @date Create in 13:31 2023/8/11
 */
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mLetters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mLetters[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            mLetters[index]--;
            if (mLetters[index] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        赎金信 clazz = new 赎金信();
        boolean b = clazz.canConstruct("a", "b");
        assert !b;
    }

    @Test
    public void test2() {
        赎金信 clazz = new 赎金信();
        boolean b = clazz.canConstruct("aa", "ab");
        assert !b;
    }

    @Test
    public void test3() {
        赎金信 clazz = new 赎金信();
        boolean b = clazz.canConstruct("aa", "aab");
        assert b;
    }
}
