package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author ZhangYao
 * @className 存在重复元素II
 * @description https://leetcode.cn/problems/contains-duplicate-ii/
 * @date Create in 16:29 2023/8/11
 */
public class 存在重复元素II {
    /**
     * 存储<数字,位置>
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int len = i - map.get(nums[i]);
                if (len <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    @Test
    public void test() {
        存在重复元素II clazz = new 存在重复元素II();
        int[] nums = {1, 2, 3, 1};
        boolean b = clazz.containsNearbyDuplicate(nums, 3);
        assert b;
    }

    @Test
    public void test2() {
        存在重复元素II clazz = new 存在重复元素II();
        int[] nums = {1, 0, 1, 1};
        boolean b = clazz.containsNearbyDuplicate(nums, 1);
        assert b;
    }

    @Test
    public void test3() {
        存在重复元素II clazz = new 存在重复元素II();
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean b = clazz.containsNearbyDuplicate(nums, 2);
        assert !b;
    }
}
