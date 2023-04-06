package com.aiz.lc.offer.day04;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer53II
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 * @date Create in 10:41 2023/4/6
 */
public class SolutionOffer53II {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        /**
         * l         m        h
         * 0 1 2 3 4 5 7 8 9 10
         * 0 1 2 3 4 5 7 9 10
         */
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        while (low <= high) {
            // 缺失的数字在mid后面
            if (mid == nums[mid]) {
                low = mid + 1;
            }
            // 缺失的数字在mid前面
            else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        return low;
    }


    /**
     * answer1 : 顺序遍历 看下标
     * answer2 : 二分
     */
}
