package com.aiz.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution39
 * @Description 组合总和
 * @Author Yao
 * @Date Create in 1:53 下午 2022/3/20
 * @Version 1.0
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 1.从小到大排序
        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        // 2.

        return result;
    }

    public static void test1() {
        Solution39 solution = new Solution39();
        int[] candidates = {2, 3, 6, 7, 1};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        // print(result);
    }

    public static void main(String[] args) {
        test1();
    }

    public static void print(List<List<Integer>> list) {
        //[[4, 1, 5, 7], [6, 9, 4, 1]]
        System.out.println(list);
    }

}
