package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 多数元素
 * @description https://leetcode.cn/problems/majority-element/
 * @date Create in 14:41 2023/8/7
 */
public class 多数元素 {

    /**
     * 摩尔投票法
     */
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count = 1;
                }
            }
        }
        return num;
    }

    @Test
    public void test() {
        多数元素 clazz = new 多数元素();
        int[] nums = new int[]{3, 2, 3};
        int i = clazz.majorityElement(nums);
        assert i == 3;
    }

    @Test
    public void test2() {
        多数元素 clazz = new 多数元素();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int i = clazz.majorityElement(nums);
        assert i == 2;
    }

    // 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题
}
