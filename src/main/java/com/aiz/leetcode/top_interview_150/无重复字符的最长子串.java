package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhangYao
 * @className 无重复字符的最长子串
 * @description https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @date Create in 16:24 2023/8/9
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char current = s.charAt(right);
            while (set.contains(current)) {
                set.remove(s.charAt(left++));
            }
            set.add(current);
            maxSize = Math.max(maxSize, right + -left + 1);
            right++;
        }
        return maxSize;
    }

    @Test
    public void test() {
        无重复字符的最长子串 clazz = new 无重复字符的最长子串();
        int i = clazz.lengthOfLongestSubstring("abcabcbb");
        assert i == 3;
    }

    @Test
    public void test2() {
        无重复字符的最长子串 clazz = new 无重复字符的最长子串();
        int i = clazz.lengthOfLongestSubstring("bbbbb");
        assert i == 1;
    }

    @Test
    public void test3() {
        无重复字符的最长子串 clazz = new 无重复字符的最长子串();
        int i = clazz.lengthOfLongestSubstring("pwwkew");
        assert i == 3;
    }
}
