package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 搜索插入位置
 * @description https://leetcode.cn/problems/search-insert-position/
 * @date Create in 23:40 2023/8/29
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, result = nums.length;
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = ((high - low) >> 1) + low;
            if (target <= nums[mid]) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int index = searchInsert(new int[]{1, 3, 5, 6}, 5);
        assert index == 2;
    }

    @Test
    public void test2() {
        int index = searchInsert(new int[]{1, 3, 5, 6}, 2);
        assert index == 1;
    }

    @Test
    public void test3() {
        int index = searchInsert(new int[]{1, 3, 5, 6}, 7);
        assert index == 4;
    }
}
