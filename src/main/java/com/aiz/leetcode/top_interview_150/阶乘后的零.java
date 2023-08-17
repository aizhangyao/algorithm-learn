package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 阶乘后的零
 * @description https://leetcode.cn/problems/factorial-trailing-zeroes/
 * @date Create in 23:29 2023/8/17
 */
public class 阶乘后的零 {
    /**
     * 算一下乘法因子里有多少个5
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    @Test
    public void test() {
        阶乘后的零 clazz = new 阶乘后的零();
        int i = clazz.trailingZeroes(3);
        assert i == 0;
    }

    @Test
    public void test2() {
        阶乘后的零 clazz = new 阶乘后的零();
        int i = clazz.trailingZeroes(5);
        assert i == 1;
    }

    @Test
    public void test3() {
        阶乘后的零 clazz = new 阶乘后的零();
        int i = clazz.trailingZeroes(0);
        assert i == 0;
    }

    @Test
    public void test4() {
        阶乘后的零 clazz = new 阶乘后的零();
        int i = clazz.trailingZeroes(10);
        assert i == 2;
    }

    @Test
    public void test5() {
        阶乘后的零 clazz = new 阶乘后的零();
        int i = clazz.trailingZeroes(30);
        assert i == 7;
    }
}
