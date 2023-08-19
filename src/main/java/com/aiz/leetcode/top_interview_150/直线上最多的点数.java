package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 直线上最多的点数
 * @description https://leetcode.cn/problems/max-points-on-a-line/
 * @date Create in 10:30 2023/8/19
 */
public class 直线上最多的点数 {

    /**
     * 暴力
     */
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int maxPoint = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int count = 2;
                for (int k = j + 1; k < points.length; k++) {
                    int x = points[k][0];
                    int y = points[k][1];
                    if ((x - x1) * (y - y2) == (x - x2) * (y - y1)) {
                        count++;
                    }
                }
                maxPoint = Math.max(maxPoint, count);
            }
        }
        return maxPoint;
    }

    @Test
    public void test() {
        直线上最多的点数 clazz = new 直线上最多的点数();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        int i = clazz.maxPoints(points);
        assert i == 3;
    }

    @Test
    public void test2() {
        直线上最多的点数 clazz = new 直线上最多的点数();
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        int i = clazz.maxPoints(points);
        assert i == 4;
    }
}
