package com.aiz.leetcode.practice;

/**
 * @ClassName Solution326
 * @Description 3的幂
 * @Author Yao
 * @Date Create in 3:00 下午 2021/9/23
 * @Version 1.0
 */
public class Solution326 {

    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(45));
    }
}
