package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 删除有序数组中的重复项II
 * @description https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
 * @date Create in 16:56 2023/8/4
 */
public class 删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        // 前一个
        int pre = nums[0];
        int preCount = 1;
        // 删除的个数
        int deleteCount = 0;
        // 从第2个到最后一个
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                if (preCount >= 2) {
                    nums[i] = 0;
                    deleteCount++;
                } else {
                    preCount++;
                    nums[i - deleteCount] = nums[i];
                }
            } else {
                preCount = 1;
                pre = nums[i];
                nums[i - deleteCount] = nums[i];
            }
        }
        return nums.length - deleteCount;
    }


    @Test
    public void test() {
        删除有序数组中的重复项II clazz = new 删除有序数组中的重复项II();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int i = clazz.removeDuplicates(nums);
        assert i == 5;
    }

    @Test
    public void test2() {
        删除有序数组中的重复项II clazz = new 删除有序数组中的重复项II();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int i = clazz.removeDuplicates(nums);
        assert i == 7;
    }

}
