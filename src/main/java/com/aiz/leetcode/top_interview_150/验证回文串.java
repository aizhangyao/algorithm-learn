package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 验证回文串
 * @description https://leetcode.cn/problems/valid-palindrome/
 * @date Create in 11:21 2023/8/9
 */
public class 验证回文串 {
    /**
     * 双指针
     */
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (isLetter(l) && isLetter(r)) {
                if (!equalsIgnoreCase(l, r)) {
                    return false;
                }
                left++;
                right--;
            }
            if (!isLetter(l)) {
                left++;
            }
            if (!isLetter(r)) {
                right--;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(char ch1, char ch2) {
        return Character.toUpperCase(ch1) == Character.toUpperCase(ch2);
    }

    public boolean isLetter(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }

    /**
     * API
     */
    public boolean isPalindrome(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sbReverse = new StringBuffer(sb).reverse();
        return sb.toString().equals(sbReverse.toString());
    }

    @Test
    public void test() {
        验证回文串 clazz = new 验证回文串();
        boolean palindrome = clazz.isPalindrome("A man, a plan, a canal: Panama");
        assert palindrome;
    }

    @Test
    public void test2() {
        验证回文串 clazz = new 验证回文串();
        boolean palindrome = clazz.isPalindrome("race a car");
        assert !palindrome;
    }

    @Test
    public void test3() {
        验证回文串 clazz = new 验证回文串();
        boolean palindrome = clazz.isPalindrome(" ");
        assert palindrome;
    }

    @Test
    public void test4() {
        验证回文串 clazz = new 验证回文串();
        boolean palindrome = clazz.isPalindrome("OP");
        assert !palindrome;
    }
}
