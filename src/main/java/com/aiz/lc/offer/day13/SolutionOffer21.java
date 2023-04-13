package com.aiz.lc.offer.day13;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer21
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @date Create in 23:09 2023/4/12
 */
public class SolutionOffer21 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     */
    public int[] exchange(int[] nums) {
        //    l      r
        // 1335 xxxx 2680
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 0) {
                // nums[i]和num[right]交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right--] = temp;
            } else {
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        int[] exchange = new SolutionOffer21().exchange(nums);
        for (int i : exchange) {
            System.out.print(i + " ");
        }
    }

    /**
     * answer1 : 双指针 原地排序
     */
}
