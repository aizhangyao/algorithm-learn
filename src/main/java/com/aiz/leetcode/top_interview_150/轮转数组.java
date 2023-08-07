package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 轮转数组
 * @description https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 * @date Create in 14:52 2023/8/7
 */
public class 轮转数组 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        k = k % nums.length;
        int[] array = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            array[i - nums.length + k] = nums[i];
        }
        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = array[i];
        }
    }

    @Test
    public void test() {
        轮转数组 clazz = new 轮转数组();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        clazz.rotate(nums, 3);
        assert equals(nums, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    public void test2() {
        轮转数组 clazz = new 轮转数组();
        int[] nums = new int[]{-1, -100, 3, 99};
        clazz.rotate(nums, 2);
        assert equals(nums, new int[]{3, 99, -1, -100});
    }


    public boolean equals(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }
}
