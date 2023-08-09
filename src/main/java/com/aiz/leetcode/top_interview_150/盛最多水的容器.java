package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 盛最多水的容器
 * @description https://leetcode.cn/problems/container-with-most-water/
 * @date Create in 12:38 2023/8/9
 */
public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int water = (right - left) * Math.min(height[left], height[right]);
            maxWater = Math.max(water, maxWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    @Test
    public void test() {
        盛最多水的容器 clazz = new 盛最多水的容器();
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = clazz.maxArea(height);
        assert i == 49;
    }

    @Test
    public void test2() {
        盛最多水的容器 clazz = new 盛最多水的容器();
        int[] height = new int[]{1, 1};
        int i = clazz.maxArea(height);
        assert i == 1;
    }
}
