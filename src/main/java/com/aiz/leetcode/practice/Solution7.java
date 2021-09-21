package com.aiz.leetcode.practice;

/**
 * @ClassName Solution7
 * @Description 整数反转    https://leetcode-cn.com/problems/reverse-integer/
 * @Author Yao
 * @Date Create in 10:38 下午 2021/9/21
 * @Version 1.0
 */
public class Solution7 {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            if (result > (Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (result < (Integer.MIN_VALUE / 10) || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}