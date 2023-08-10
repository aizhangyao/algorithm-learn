package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 两数之和II_输入有序数组
 * @description https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * @date Create in 12:00 2023/8/9
 */
public class 两数之和II_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int num = numbers[left] + numbers[right];
            if (num == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (num < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    @Test
    public void test() {
        两数之和II_输入有序数组 clazz = new 两数之和II_输入有序数组();
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] ints = clazz.twoSum(numbers, 9);
        int[] expectedResult = new int[]{1, 2};
        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test2() {
        两数之和II_输入有序数组 clazz = new 两数之和II_输入有序数组();
        int[] numbers = new int[]{2, 3, 4};
        int[] ints = clazz.twoSum(numbers, 6);
        int[] expectedResult = new int[]{1, 3};
        BaseTool.equals(ints, expectedResult);
    }
}
