package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author ZhangYao
 * @className 最长连续序列
 * @description https://leetcode.cn/problems/longest-consecutive-sequence/
 * @date Create in 16:43 2023/8/11
 */
public class 最长连续序列 {
    public int longestConsecutive2(int[] nums) {
        // 去重
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int longestStreak = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] == nums[i + 1] - 1) {
                max++;
            } else {
                result = Math.max(result, max);
                max = 1;
            }
            result = Math.max(result, max);
        }
        return result;
    }

    @Test
    public void test() {
        最长连续序列 clazz = new 最长连续序列();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int i = clazz.longestConsecutive(nums);
        assert i == 4;
    }

    @Test
    public void test2() {
        最长连续序列 clazz = new 最长连续序列();
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int i = clazz.longestConsecutive(nums);
        assert i == 9;
    }
}
