package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 接雨水
 * @description https://leetcode.cn/problems/trapping-rain-water/
 * @date Create in 11:56 2023/8/8
 */
public class 接雨水 {
    public int trap(int[] height) {
        // find max index
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        int rainWater = 0;
        // 0 --> maxIndex
        int leftMax = height[0];
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] < leftMax) {
                rainWater += (leftMax - height[i]);
            } else {
                leftMax = height[i];
            }
        }

        // length --> maxIndex
        int rightMax = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] < rightMax) {
                rainWater += (rightMax - height[i]);
            } else {
                rightMax = height[i];
            }
        }
        return rainWater;
    }

    @Test
    public void test() {
        接雨水 clazz = new 接雨水();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = clazz.trap(height);
        assert trap == 6;
    }

    @Test
    public void test2() {
        接雨水 clazz = new 接雨水();
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int trap = clazz.trap(height);
        assert trap == 9;
    }

    @Test
    public void test3() {
        接雨水 clazz = new 接雨水();
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int trap = clazz.trap(height);
        assert trap == 9;
    }
}

/**
 * 对于第i个。这一列可以接到到雨水等于min(第i列左边最高的,第i列右边最高的)-i的高度    min(left_max,right_max) - i
 *
 * 可以for循环
 *
 * 也可以用两个数组分别把第i列左右最高第存起来
 *
 * 也可以先找出最高的位置。然后在遍历的时候，不断更新左边或者右边最高的。
 */
