package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 跳跃游戏II
 * @description https://leetcode.cn/problems/jump-game-ii/
 * @date Create in 16:06 2023/8/7
 */
public class 跳跃游戏II {
    public int jump(int[] nums) {
        // 0, 1, 2, 3, 4
        // 3, 2, 1, 0, 4
        // 3, 3, 3, 3, 8
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        // 最远的覆盖范围cover
        int cover = 0;
        // 步数
        int step = 0;
        // 记录上一步step跳的最远距离
        int end = 0;
        for (int i = 0; i < length; i++) {
            // 记录在第i块石头上的最远覆盖范围
            cover = Math.max(cover, i + nums[i]);
            // 走完了
            if (cover >= length - 1) {
                return step + 1;
            }
            // 每一步的最远距离
            if (end == i) {
                step++;
                end = cover;
            }
        }
        return step;
    }

    @Test
    public void test() {
        跳跃游戏II clazz = new 跳跃游戏II();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int jump = clazz.jump(nums);
        assert jump == 2;
    }

    @Test
    public void test2() {
        跳跃游戏II clazz = new 跳跃游戏II();
        int[] nums = new int[]{2, 3, 0, 1, 4};
        int jump = clazz.jump(nums);
        assert jump == 2;
    }

    @Test
    public void test3() {
        跳跃游戏II clazz = new 跳跃游戏II();
        int[] nums = new int[]{2, 1};
        int jump = clazz.jump(nums);
        assert jump == 1;
    }

    @Test
    public void test4() {
        跳跃游戏II clazz = new 跳跃游戏II();
        int[] nums = new int[]{1, 2, 3};
        int jump = clazz.jump(nums);
        assert jump == 2;
    }
}
