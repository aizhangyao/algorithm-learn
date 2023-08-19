package com.aiz.nowcoder.huawei.exam20230818;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String[] split = s.split(",");
        String[] split = new String[]{"1", "0", "1", "0", "0", "0", "1", "0", "1"};
        System.out.println("sss"+split.length);
        int n = (int) Math.sqrt(split.length);
        System.out.println("eee"+n);
        int[][] map = new int[n][n];
        // 统计被感染的个数
        int num = 0;
        // 1,0,1,0,0,0,1,0,1
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
            int temp = Integer.parseInt(split[i]);
            map[i / 3][i % 3] = temp;
            if (temp == 1) {
                num++;
            }
        }
        if (num == 0 || num == split.length) {
            System.out.println(-1);
            return;
        }

        int day = 0;
        int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (num != split.length) {
            // 备份一下
            int[][] copyMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }
            // 污染其他区域
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 如果感染了，那么他的四周也要感染
                    if (copyMap[i][j] == 1) {
                        for (int k = 0; k < d.length; k++) {
                            int newR = i + d[k][0];
                            int newC = j + d[k][1];
                            if (newR >= 0 && newR < n && newC >= 0 && newC < n) {
                                if (map[newR][newC] == 0) {
                                    num++;
                                }
                                map[newR][newC] = 1;
                            }
                        }
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
