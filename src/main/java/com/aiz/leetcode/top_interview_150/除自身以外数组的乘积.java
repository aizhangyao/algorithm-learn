package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangYao
 * @className 除自身以外数组的乘积
 * @description https://leetcode.cn/problems/product-of-array-except-self/
 * @date Create in 18:46 2023/8/7
 */
public class 除自身以外数组的乘积 {
    /**
     * pass 不能使用除法
     */
    public int[] productExceptSelf2(int[] nums) {
        int res = 1;
        for (int num : nums) {
            res *= num;
        }
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = res * nums[i] ^ -1;
        }
        return results;
    }

    /**
     * 前缀之积 * 后缀之积
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // 前缀之积
        int[] L = new int[length];
        // 后缀之积
        int[] R = new int[length];

        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    @Test
    public void test() {
        除自身以外数组的乘积 clazz = new 除自身以外数组的乘积();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] array = clazz.productExceptSelf(nums);
        Arrays.equals(array, new int[]{24, 12, 8, 6});
    }

    @Test
    public void test2() {
        除自身以外数组的乘积 clazz = new 除自身以外数组的乘积();
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] array = clazz.productExceptSelf(nums);
        Arrays.equals(array, new int[]{0, 0, 9, 0, 0});
    }

}
