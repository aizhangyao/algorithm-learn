package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZhangYao
 * @className 合并区间
 * @description https://leetcode.cn/problems/merge-intervals/
 * @date Create in 12:42 2023/8/12
 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            i++;
            while (i < intervals.length && intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
                i++;
            }
            list.add(new int[]{start, end});
        }

        int[][] ints = new int[list.size()][];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = list.get(j);
        }
        return ints;
    }


    @Test
    public void test() {
        合并区间 clazz = new 合并区间();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = clazz.merge(intervals);
        int[][] expectedResult = {{1, 6}, {8, 10}, {15, 18}};
        BaseTool.equals(merge, expectedResult);
    }

    @Test
    public void test2() {
        合并区间 clazz = new 合并区间();
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] merge = clazz.merge(intervals);
        int[][] expectedResult = {{1, 5}};
        BaseTool.equals(merge, expectedResult);
    }

    @Test
    public void test3() {
        合并区间 clazz = new 合并区间();
        int[][] intervals = {{1, 4}, {0, 4}};
        int[][] merge = clazz.merge(intervals);
        int[][] expectedResult = {{0, 4}};
        BaseTool.equals(merge, expectedResult);
    }
}
