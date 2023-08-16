package com.aiz.nowcoder.od.q2_2023;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 划分字符串
 * @description https://www.online1987.com/划分字符串/
 * @date Create in 14:47 2023/8/16
 */
public class 划分字符串 {
    /**
     * 给定一个字符串，只包含小写字母，字符串长度是 5-30
     * 求：是否存在两个节点，使得字符串被这两个节点分成三个部分，每个部分的 ASCII 码的值之和都相等，
     * 如果存在输出两个节点下标，以逗号隔开。下标从 0 开始 ，如果不存在，则输出 0,0。
     * 如果存在答案，则是唯一解。
     * <p>
     * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * aabaacaa
     * 输出
     * 2,5
     * <p>
     * 示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
     * 输入
     * abacd
     * 输出
     * 0,0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.next()));
    }

    public static String getResult(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        // 前缀和
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + chars[i - 1];
        }
        // i,j是分割点
        for (int i = 1; i < n; i++) {
            // sum1 是 0 ~ i-1 范围的ASCII码之和
            int sum1 = preSum[i] - preSum[0];
            for (int j = i + 2; j < n; j++) {
                // sum2 是 i + 1 ~ j - 1 范围的ASCII码之和
                int sum2 = preSum[j] - preSum[i + 1];
                // 剪枝
                if (sum1 < sum2) {
                    break;
                }
                if (sum1 == sum2) {
                    // sum3 是 j + 1 ~ n - 1 范围的ASCII码之和
                    int sum3 = preSum[n] - preSum[j + 1];
                    if (sum2 == sum3) {
                        return i + "," + j;
                    }
                }
            }
        }
        return "0,0";
    }
}
