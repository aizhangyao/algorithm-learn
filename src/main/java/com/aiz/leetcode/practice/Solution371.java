package com.aiz.leetcode.practice;

/**
 * @ClassName Solution371
 * @Description 两整数之和
 * @Author Yao
 * @Date Create in 8:35 下午 2021/9/26
 * @Version 1.0
 */
public class Solution371 {

    /**
     * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
     *
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 1));
        System.out.println(7&8);
    }
}
