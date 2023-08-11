package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author ZhangYao
 * @className 快乐数
 * @description https://leetcode.cn/problems/happy-number/
 * @date Create in 16:08 2023/8/11
 */
public class 快乐数 {
    public boolean isHappy(int n) {
        HashSet set = new HashSet();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }

    @Test
    public void test() {
        快乐数 clazz = new 快乐数();
        boolean happy = clazz.isHappy(19);
        assert happy;
    }

    @Test
    public void test2() {
        快乐数 clazz = new 快乐数();
        boolean happy = clazz.isHappy(2);
        assert !happy;
    }

    @Test
    public void test3() {
        快乐数 clazz = new 快乐数();
        boolean happy = clazz.isHappy(7);
        assert happy;
    }
}
