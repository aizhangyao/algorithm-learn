package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 组合
 * @description https://leetcode.cn/problems/combinations/
 * @date Create in 09:54 2023/8/30
 */
public class 组合 {
    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     */
    List<List<Integer>> combines = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return combines;
        }
        backtracking(n, k, 1);
        return combines;
    }

    /**
     * @param startIndex 每次搜索的起始位置
     */
    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            combines.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> combines = combine(4, 2);
        int[][] arr = {{2, 4}, {3, 4}, {2, 3}, {1, 2}, {1, 3}, {1, 4}};
    }


    @Test
    public void test2() {
        List<List<Integer>> combines = combine(1, 1);
        int[][] arr = {{1}};
    }

}
