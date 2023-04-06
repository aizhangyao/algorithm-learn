package com.aiz.lc.offer.day04;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer53I
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @date Create in 11:20 2023/4/6
 */
public class SolutionOffer53I {

    public int search(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                sum++;
            }
        }
        return sum;
    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //
            if (target < nums[mid]) {
                high = mid - 1;
            }
            //
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            //
            else {
                if (nums[low] != target) {
                    low++;
                } else if (nums[high] != target) {
                    high--;
                } else {
                    break;
                }
            }
        }
        return high - low + 1;
    }

    /**
     * answer1 : 直接一层遍历，太傻了。可以用来写对数器。要是直接写肯定回家等通知。
     * answer2 : 因为是排序数组，二分。比较target找左边界和右边界。
     */
}
