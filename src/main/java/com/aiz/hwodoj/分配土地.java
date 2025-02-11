package com.aiz.hwodoj;

import java.util.*;

/**
 * @author ZhangYao
 * @className 分配土地
 * @description 分配土地
 * @date Create in 01:57 2025/2/8
 */
public class 分配土地 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 行数、列数
        int rowCount = in.nextInt();
        int colCount = in.nextInt();
        int[][] land = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                land[i][j] = in.nextInt();
            }
        }
        in.close();
        // 存储每个数字最大和最小位置
        Map<Integer, int[]> minPos = new HashMap<>();
        Map<Integer, int[]> maxPos = new HashMap<>();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int num = land[i][j];
                if (num != 0) {
                    if (!minPos.containsKey(num)) {
                        minPos.put(num, new int[]{i, j});
                        maxPos.put(num, new int[]{i, j});
                    } else {
                        int[] min = minPos.get(num);
                        min[0] = Math.min(min[0], i);
                        min[1] = Math.min(min[1], j);
                        int[] max = maxPos.get(num);
                        max[0] = Math.max(max[0], i);
                        max[1] = Math.max(max[1], j);
                    }
                }
            }
        }

        //
        int maxArea = 0;
        for (Integer i : minPos.keySet()) {
            int[] min = minPos.get(i);
            int[] max = maxPos.get(i);
            int area = (max[0] - min[0] + 1) * (max[1] - min[1] + 1);
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }
}