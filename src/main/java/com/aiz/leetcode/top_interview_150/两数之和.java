package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ZhangYao
 * @className 两数之和
 * @description https://leetcode.cn/problems/two-sum/
 * @date Create in 16:00 2023/8/11
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i], i);
        }
        return new int[]{-2, -2};
    }

    @Test
    public void test() {
        两数之和 clazz = new 两数之和();
        int[] nums = {2, 7, 11, 15};
        int[] ints = clazz.twoSum(nums, 9);
        int[] expectedResult = {0, 1};
        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test2() {
        两数之和 clazz = new 两数之和();
        int[] nums = {3, 2, 4};
        int[] ints = clazz.twoSum(nums, 6);
        int[] expectedResult = {1, 2};
        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test3() {
        两数之和 clazz = new 两数之和();
        int[] nums = {3, 3};
        int[] ints = clazz.twoSum(nums, 6);
        int[] expectedResult = {0, 1};
        BaseTool.equals(ints, expectedResult);
    }
}
