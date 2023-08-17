package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 回文数
 * @description https://leetcode.cn/problems/palindrome-number/
 * @date Create in 23:02 2023/8/17
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    @Test
    public void test() {
        回文数 clazz = new 回文数();
        boolean palindrome = clazz.isPalindrome(121);
        assert palindrome;
    }

    @Test
    public void test2() {
        回文数 clazz = new 回文数();
        boolean palindrome = clazz.isPalindrome(1121);
        assert !palindrome;
    }

    @Test
    public void test3() {
        回文数 clazz = new 回文数();
        boolean palindrome = clazz.isPalindrome(10);
        assert !palindrome;
    }
}
