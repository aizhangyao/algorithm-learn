package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 全排列
 * @description https://leetcode.cn/problems/permutations/
 * @date Create in 11:10 2023/8/30
 */
public class 全排列 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtracking(0, path, nums);
        return res;
    }

    private void backtracking(int startIndex, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtracking(startIndex + 1, path, nums);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
    }

    @Test
    public void test2() {
        List<List<Integer>> permute = permute(new int[]{0, 1});
    }

    @Test
    public void test3() {
        List<List<Integer>> permute = permute(new int[]{1});
    }
}
