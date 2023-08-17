package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className x的平方根
 * @description https://leetcode.cn/problems/sqrtx/
 * @date Create in 23:58 2023/8/17
 */
public class x的平方根 {
    /**
     * 二分查找
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0, right = x;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (x / mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    @Test
    public void test() {
        x的平方根 clazz = new x的平方根();
        int i = clazz.mySqrt(4);
        assert i == 2;
    }

    @Test
    public void test2() {
        x的平方根 clazz = new x的平方根();
        int i = clazz.mySqrt(8);
        assert i == 2;
    }
}
