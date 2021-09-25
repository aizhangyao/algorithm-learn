package com.aiz.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution15
 * @Description 三数之和
 * @Author Yao
 * @Date Create in 12:52 下午 2021/9/23
 * @Version 1.0
 */
public class Solution15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1.从小到大排序
        Arrays.sort(nums);
        // 2.固定一个i，使用双指针
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
                if (sum < 0) {
                    left++;
                }
                if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("输入 " + Arrays.toString(nums));
        System.out.println("输出 " + threeSum(nums));

        int[] nums2 = new int[]{0,0,0};
        System.out.println("输入 " + Arrays.toString(nums2));
        System.out.println("输出 " + threeSum(nums2));
    }

}
