package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className 螺旋矩阵
 * @description https://leetcode.cn/problems/spiral-matrix/
 * @date Create in 23:01 2023/8/9
 */
public class 螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();

        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        // 右 下 左 上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // m 行, n 列
        int m = 0, n = 0, directionIndex = 0;
        // 遍历rows * columns次
        for (int i = 0; i < rows * columns; i++) {
            order.add(matrix[m][n]);
            visited[m][n] = true;
            int nextRow = m + directions[directionIndex][0];
            int nextCol = n + directions[directionIndex][1];
            // 如果走出了矩阵 || 走到了访问过的格子
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            m += directions[directionIndex][0];
            n += directions[directionIndex][1];
        }
        return order;
    }

    @Test
    public void test() {
        螺旋矩阵 clazz = new 螺旋矩阵();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = clazz.spiralOrder(matrix);
        Integer[] array = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        expected(list, array);
    }

    @Test
    public void test2() {
        螺旋矩阵 clazz = new 螺旋矩阵();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = clazz.spiralOrder(matrix);
        Integer[] array = {1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        expected(list, array);
    }

    private void expected(List<Integer> list, Integer[] array) {
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.addAll(Arrays.asList(array));
        assert list.size() == expectedResult.size();
        for (int i = 0; i < list.size(); i++) {
            assert Objects.equals(list.get(i), expectedResult.get(i));
        }
    }
}
