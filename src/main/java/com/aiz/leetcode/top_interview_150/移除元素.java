package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @version 1.0
 * @className 移除元素
 * @description https://leetcode.cn/problems/remove-element/
 * @date Create in 16:06 2023/8/4
 */
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        int len = nums.length;
        while (fast < len) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test() {
        移除元素 clazz = new 移除元素();
        int[] nums = new int[]{3, 2, 2, 3};
        clazz.removeElement(nums, 3);
        System.out.println();
    }
}
