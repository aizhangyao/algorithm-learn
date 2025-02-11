package com.aiz.hwodoj;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author ZhangYao
 * @className 最多购买宝石
 * @description 最多购买宝石
 * @date Create in 17:43 2025/2/11
 */
public class 最多购买宝石 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] gems = new int[n];
        for (int i = 0; i < n; i++) {
            gems[i] = in.nextInt();
        }
        int v = in.nextInt();
        in.close();

        int maxNum = maxBuyNum(gems, v);
        System.out.println(maxNum);
    }

    public static int maxBuyNum(int[] gems, int value) {
        // 最大可以购买数量
        int maxNum = 0;
        // 滑动窗口 左右指针 窗口内宝石总价
        int right = 0, left = 0, sum = 0;
        while (right < gems.length) {
            sum += gems[right];
            while (sum > value) {
                sum -= gems[left];
                left++;
            }
            maxNum = Math.max(maxNum, right - left + 1);
            right++;
        }
        return maxNum;
    }

    @Test
    public void test() {
        int[] gems = {8, 4, 6, 3, 1, 6, 7};
        int v = 10;
        int maxNum = maxBuyNum(gems, v);
        assert maxNum == 3;
    }
}
