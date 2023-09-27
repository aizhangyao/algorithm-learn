package com.aiz.leetcode.practice;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 旋转数组
 * @description https://leetcode.cn/problems/rotate-array/
 * 这题我在2023年9月25日面试快手遇到了！！！
 * @date Create in 17:02 2023/9/27
 */
public class 旋转数组 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // 交换nums[start]和nums[end]
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 时间复杂度kn，运行不通过，超时
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            nums[0] = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                int t = nums[j];
                nums[j] = temp;
                temp = t;
            }
        }
    }

    // 1,2,3,4,5
    // 5,1,2,3,4

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        BaseTool.equals(nums, new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    public void test2() {
        int[] nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        BaseTool.equals(nums, new int[]{3, 99, -1, -100});
    }
}
