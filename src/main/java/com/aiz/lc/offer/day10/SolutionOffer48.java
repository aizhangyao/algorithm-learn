package com.aiz.lc.offer.day10;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer48
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @date Create in 23:07 2023/4/8
 */
public class SolutionOffer48 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int left = 0, right = 0; right < chars.length; right++) {
            char current = chars[right];
            // chars[right]为结尾的最长的不包含重复字符串
            while (set.contains(current)) {
                set.remove(chars[left++]);
            }
            set.add(current);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new SolutionOffer48().lengthOfLongestSubstring("aab"));
    }
    /**
     * answer1 : 滑动窗口 双指针
     */
}
