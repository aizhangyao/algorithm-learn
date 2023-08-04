package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @version 1.0
 * @className 删除有序数组中的重复项
 * @description https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * @date Create in 16:46 2023/8/4
 */
public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int deleteCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                deleteCount++;
            } else {
                pre = nums[i];
                nums[i - deleteCount] = nums[i];
            }
        }
        return nums.length - deleteCount;
    }

    @Test
    public void test() {
        删除有序数组中的重复项 clazz = new 删除有序数组中的重复项();
        int[] nums = new int[]{1, 1, 2};
        int i = clazz.removeDuplicates(nums);
        assert i == 2;
    }
}
