package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 有效的字母异位词
 * @description https://leetcode.cn/problems/valid-anagram/
 * @date Create in 14:50 2023/8/11
 */
public class 有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        有效的字母异位词 clazz = new 有效的字母异位词();
        boolean anagram = clazz.isAnagram("anagram", "nagaram");
        assert anagram;
    }

    @Test
    public void test2() {
        有效的字母异位词 clazz = new 有效的字母异位词();
        boolean anagram = clazz.isAnagram("rat", "car");
        assert !anagram;
    }

    @Test
    public void test3() {
        有效的字母异位词 clazz = new 有效的字母异位词();
        boolean anagram = clazz.isAnagram("a", "ab");
        assert !anagram;
    }

    /**
     * hash表
     * 另外一种思路：排序后逐一比较
     */
}
