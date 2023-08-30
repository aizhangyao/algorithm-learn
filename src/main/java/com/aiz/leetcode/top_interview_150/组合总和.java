package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 组合总和
 * @description https://leetcode.cn/problems/combination-sum/
 * @date Create in 11:31 2023/8/30
 */
public class 组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    /**
     * 表示当前在candidates数组第idx位置，还剩target要组合，已经组合的列表为path。
     * 终止条件：数组用完 或者 target<=0
     */
    private void dfs(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 跳过不用第idx个数字
        dfs(candidates, target, idx + 1);
        // 使用第idx个数字
        if (target - candidates[idx] >= 0) {
            path.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], idx);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> combinations = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println();
    }

}
