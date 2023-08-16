package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 插入区间
 * @description https://leetcode.cn/problems/insert-interval/
 * @date Create in 18:54 2023/8/12
 */
public class 插入区间 {
    /**
     * answer1
     * 先找出所有重叠的区间
     * 将重叠的区间和要加入的区间合并成大区间
     * 最后把不重叠的区间+合并后的大区间
     * answer2
     * 分三段
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int L = newInterval[0];
        int R = newInterval[1];
        int index = 0;
        while (index < intervals.length && intervals[index][1] < L) {
            list.add(intervals[index++]);
        }
        while (index < intervals.length && intervals[index][0] <= R) {
            L = Math.min(L, intervals[index][0]);
            R = Math.max(R, intervals[index][1]);
            index++;
        }
        list.add(new int[]{L, R});
        while (index < intervals.length) {
            list.add(intervals[index++]);
        }
        int[][] ints = new int[list.size()][];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = list.get(j);
        }
        return ints;
    }

    @Test
    public void test() {
        插入区间 clazz = new 插入区间();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = clazz.insert(intervals, newInterval);
        int[][] expectedResult = {{1, 5}, {6, 9}};
        BaseTool.equals(insert, expectedResult);
    }

    @Test
    public void test2() {
        插入区间 clazz = new 插入区间();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = clazz.insert(intervals, newInterval);
        int[][] expectedResult = {{1, 2}, {3, 10}, {12, 16}};
        BaseTool.equals(insert, expectedResult);
    }

    @Test
    public void test3() {
        插入区间 clazz = new 插入区间();
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] insert = clazz.insert(intervals, newInterval);
        int[][] expectedResult = {{5, 7}};
        BaseTool.equals(insert, expectedResult);
    }

    @Test
    public void test4() {
        插入区间 clazz = new 插入区间();
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] insert = clazz.insert(intervals, newInterval);
        int[][] expectedResult = {{1, 5}};
        BaseTool.equals(insert, expectedResult);
    }

    @Test
    public void test5() {
        插入区间 clazz = new 插入区间();
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] insert = clazz.insert(intervals, newInterval);
        int[][] expectedResult = {{1, 7}};
        BaseTool.equals(insert, expectedResult);
    }
}
