package com.aiz.lc.offer.day13;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer57
 * @description 剑指 Offer 57. 和为s的两个数字
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @date Create in 17:00 2023/4/13
 */
public class SolutionOffer57 {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     */
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionOffer57 solutionOffer57 = new SolutionOffer57();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = solutionOffer57.twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
    /**
     * answer1 : 双指针
     */
}
