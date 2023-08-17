package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 加一
 * @description https://leetcode.cn/problems/plus-one/
 * @date Create in 23:11 2023/8/17
 */
public class 加一 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = carry + digits[i];
            digits[i] = val % 10;
            carry = val / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }
        return res;
    }

    @Test
    public void test() {
        加一 clazz = new 加一();
        int[] digits = {1, 2, 3};
        int[] ints = clazz.plusOne(digits);
        int[] expectedResult = {1, 2, 4};
        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test2() {
        加一 clazz = new 加一();
        int[] digits = {4, 3, 2, 1};
        int[] ints = clazz.plusOne(digits);
        int[] expectedResult = {4, 3, 2, 2};
        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test3() {
        加一 clazz = new 加一();
        int[] digits = {0};
        int[] ints = clazz.plusOne(digits);
        int[] expectedResult = {1};
        BaseTool.equals(ints, expectedResult);
    }
}
