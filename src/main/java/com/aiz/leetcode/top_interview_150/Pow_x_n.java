package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className Pow_x_n
 * @description https://leetcode.cn/problems/powx-n/
 * @date Create in 00:13 2023/8/18
 */
public class Pow_x_n {
    public double myPow(double x, int n) {
        long N = n < 0 ? -(long) n : n;
        double ans = pow(x, N);
        return n < 0 ? 1 / ans : ans;
    }

    public double pow(double x, long n) {
        // x^n
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        }
        return x * pow(x * x, n / 2);
    }

    @Test
    public void test() {
        Pow_x_n clazz = new Pow_x_n();
        double v = clazz.myPow(2d, 10);
        assert v == 1024d;
    }

    @Test
    public void test2() {
        Pow_x_n clazz = new Pow_x_n();
        double v = clazz.myPow(2.1d, 3);
        assert v == 9.261000000000001d;
    }

    @Test
    public void test3() {
        Pow_x_n clazz = new Pow_x_n();
        double v = clazz.myPow(2d, -2);
        assert v == 0.25d;
    }
}
