package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 合并两个有序数组
 * @description https://leetcode.cn/problems/merge-sorted-array/
 * @date Create in 15:20 2023/8/4
 */
public class 合并两个有序数组 {
    /**
     * 我傻逼了，可以从后往前搞--->merge2
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = n + m;
        // 先把nums放在后面
        for (int i = len - 1; i >= n; i--) {
            nums1[i] = nums1[i - n];
        }
        // m = 3
        // n = 4
        // nums1 0 1 2 (3) 4 5 6
        int index1 = n, index2 = 0;
        int index = 0;
        while (index1 < len && index2 < n) {
            nums1[index++] = nums1[index1] < nums2[index2] ? nums1[index1++] : nums2[index2++];
        }
        while (index2 < n) {
            nums1[index++] = nums2[index2++];
        }
    }

    @Test
    public void test1() {
        合并两个有序数组 clazz = new 合并两个有序数组();
        int[] nums1 = new int[]{1, 2, 4, 5, 6, 0};
        int[] nums2 = new int[]{3};
        clazz.merge(nums1, 5, nums2, 1);
        System.out.println();
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[index--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
        }
        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }

    @Test
    public void test2() {
        合并两个有序数组 clazz = new 合并两个有序数组();
        int[] nums1 = new int[]{1, 2, 4, 5, 6, 0};
        int[] nums2 = new int[]{3};
        clazz.merge2(nums1, 5, nums2, 1);
        System.out.println();
    }

}
