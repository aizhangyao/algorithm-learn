package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author ZhangYao
 * @className 整数转罗马数字
 * @description https://leetcode.cn/problems/integer-to-roman/
 * @date Create in 15:26 2023/8/8
 */
public class 整数转罗马数字 {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        if (num < 1 || num > 3999) {
            return roman.toString();
        }
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < nums.length; i++) {
            int m = num / nums[i];
            for (int j = 0; j < m; j++) {
                roman.append(getRoman(nums[i]));
            }
            num = num % nums[i];
        }
        return roman.toString();
    }

    private String getRoman(int value) {
        switch (value) {
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "";
        }
    }

    @Test
    public void test() {
        整数转罗马数字 clazz = new 整数转罗马数字();
        String s = clazz.intToRoman(3);
        assert Objects.equals(s, "III");
    }

    @Test
    public void test2() {
        整数转罗马数字 clazz = new 整数转罗马数字();
        String s = clazz.intToRoman(4);
        assert Objects.equals(s, "IV");
    }

    @Test
    public void test3() {
        整数转罗马数字 clazz = new 整数转罗马数字();
        String s = clazz.intToRoman(9);
        assert Objects.equals(s, "IX");
    }

    @Test
    public void test4() {
        整数转罗马数字 clazz = new 整数转罗马数字();
        String s = clazz.intToRoman(58);
        // L = 50, V = 5, III = 3.
        assert Objects.equals(s, "LVIII");
    }

    @Test
    public void test5() {
        整数转罗马数字 clazz = new 整数转罗马数字();
        String s = clazz.intToRoman(1994);
        // M = 1000, CM = 900, XC = 90, IV = 4.
        assert Objects.equals(s, "MCMXCIV");
    }
}
