package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 判断子序列
 * @description https://leetcode.cn/problems/is-subsequence/
 * @date Create in 11:49 2023/8/9
 */
public class 判断子序列 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex <= s.length() - 1 && tIndex <= t.length() - 1) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
            if (sIndex == s.length()) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        判断子序列 clazz = new 判断子序列();
        boolean subsequence = clazz.isSubsequence("abc", "ahbgdc");
        assert subsequence;
    }

    @Test
    public void test2() {
        判断子序列 clazz = new 判断子序列();
        boolean subsequence = clazz.isSubsequence("axc", "ahbgdc");
        assert !subsequence;
    }

    @Test
    public void test3() {
        判断子序列 clazz = new 判断子序列();
        boolean subsequence = clazz.isSubsequence("", "ahbgdc");
        assert subsequence;
    }

}
