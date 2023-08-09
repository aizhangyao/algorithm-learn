package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 长度最小的子数组
 * @description https://leetcode.cn/problems/minimum-size-subarray-sum/
 * @date Create in 14:37 2023/8/9
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int minSize = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (left <= right && right <= nums.length - 1) {
            sum += nums[right];
            while (sum >= target && left <= right) {
                minSize = Math.min(right - left + 1, minSize);
                sum -= nums[left++];
            }
            right++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    @Test
    public void test() {
        长度最小的子数组 clazz = new 长度最小的子数组();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int i = clazz.minSubArrayLen(7, nums);
        assert i == 2;
    }

    @Test
    public void test2() {
        长度最小的子数组 clazz = new 长度最小的子数组();
        int[] nums = new int[]{1, 4, 4};
        int i = clazz.minSubArrayLen(4, nums);
        assert i == 1;
    }

    @Test
    public void test3() {
        长度最小的子数组 clazz = new 长度最小的子数组();
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int i = clazz.minSubArrayLen(11, nums);
        assert i == 0;
    }

    @Test
    public void test4() {
        长度最小的子数组 clazz = new 长度最小的子数组();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int i = clazz.minSubArrayLen(11, nums);
        assert i == 3;
    }
}
