package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangYao
 * @className 用最少数量的箭引爆气球
 * @description https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @date Create in 08:50 2023/8/16
 */
public class 用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        // 先排序，
        // 然后前一个和后一个找重叠区间，如果有重叠区间，继续用重叠区间和下一个比较，直到没有重叠区间，弓箭数量+1
        // 然后重复上面找重叠区间操作
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        int arrowShot = 0, i = 0, L, R;
        while (i < points.length) {
            L = points[i][0];
            R = points[i][1];
            while (i < points.length && R >= points[i][0]) {
                L = Math.max(L, points[i][0]);
                R = Math.min(R, points[i][1]);
                i++;
            }
            arrowShot++;
        }
        return arrowShot;
    }

    @Test
    public void test() {
        用最少数量的箭引爆气球 clazz = new 用最少数量的箭引爆气球();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = clazz.findMinArrowShots(points);
        assert minArrowShots == 2;
    }

    @Test
    public void test2() {
        用最少数量的箭引爆气球 clazz = new 用最少数量的箭引爆气球();
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int minArrowShots = clazz.findMinArrowShots(points);
        assert minArrowShots == 4;
    }

    @Test
    public void test3() {
        用最少数量的箭引爆气球 clazz = new 用最少数量的箭引爆气球();
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int minArrowShots = clazz.findMinArrowShots(points);
        assert minArrowShots == 2;
    }

    @Test
    public void test4() {
        用最少数量的箭引爆气球 clazz = new 用最少数量的箭引爆气球();
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        int minArrowShots = clazz.findMinArrowShots(points);
        assert minArrowShots == 2;
    }
}
