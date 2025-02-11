package com.aiz.hwodoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 多段线数据压缩
 * @description 多段线数据压缩
 * @date Create in 17:21 2025/2/11
 */
public class 多段线数据压缩 {
    public static void main(String[] args) {
        // 读取坐标
        Scanner in = new Scanner(System.in);
        List<int[]> points = new ArrayList<>();
        while (in.hasNext()) {
            int x = in.nextInt();
            int y = in.nextInt();
            points.add(new int[]{x, y});
        }
        in.close();

        // 简化路径
        List<int[]> simplifiedPoints = simplifyPath(points);

        // print
        for (int i = 0; i < simplifiedPoints.size(); i++) {
            int[] point = simplifiedPoints.get(i);
            System.out.print(point[0] + " " + point[1]);
            if (i != simplifiedPoints.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static List<int[]> simplifyPath(List<int[]> points) {
        if (points.size() < 2) {
            return points;
        }
        List<int[]> simplifiedPoints = new ArrayList<>();
        simplifiedPoints.add(points.get(0));
        for (int i = 1; i < points.size() - 1; i++) {
            int[] pre = points.get(i - 1);
            int[] curr = points.get(i);
            int[] next = points.get(i + 1);
            if (isTurningPoint(pre, curr, next)) {
                simplifiedPoints.add(curr);
            }
        }
        simplifiedPoints.add(points.get(points.size() - 1));
        return simplifiedPoints;
    }

    private static boolean isTurningPoint(int[] pre, int[] curr, int[] next) {
        // 计算向量
        int dx1 = curr[0] - pre[0];
        int dy1 = curr[1] - pre[1];
        int dx2 = next[0] - curr[0];
        int dy2 = next[1] - curr[1];

        return dx1 * dy2 != dx2 * dy1;
    }
}
