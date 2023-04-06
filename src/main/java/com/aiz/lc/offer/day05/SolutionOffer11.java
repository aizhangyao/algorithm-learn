package com.aiz.lc.offer.day05;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer11
 * @description 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @date Create in 17:08 2023/4/6
 */
public class SolutionOffer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        // 交替使用二分和暴力
        while (left < right) {
            int mid = (left + right) / 2;
            // 1234555 --> 5512345
            if (numbers[mid] < numbers[right]) {
                right = mid;
            }
            // 12355555 --> 55555123
            else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            }
            // 右指针左移一位 (暴力遍历)
            else {
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * answer1 : 暴力解法
     * answer2 : 交替使用二分和暴力
     */
}
