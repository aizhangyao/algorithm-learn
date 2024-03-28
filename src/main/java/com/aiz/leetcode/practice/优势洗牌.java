package com.aiz.leetcode.practice;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ZhangYao
 * @className 优势洗牌
 * @description https://leetcode.cn/problems/advantage-shuffle/
 * @date Create in 17:03 2024/3/25
 */
public class 优势洗牌 {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 对nums1任意排列,nums2不变, 使nums1[i] > nums2[i]最多

        // 贪心
        // 创建数组idx1,idx2记录原数字位置
        int len = nums1.length;
        Integer[] idx1 = new Integer[len];
        Integer[] idx2 = new Integer[len];
        for (int i = 0; i < len; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }
        // 对idx1,idx2从小到大排序 {大小比较标准看num[i]}
        Arrays.sort(idx1, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                return nums1[i] - nums1[j];
            }
        });
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        //
        int[] res = new int[len];
        int left = 0, right = len - 1;
        for (int i = 0; i < len; i++) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                res[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                res[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        优势洗牌 y = new 优势洗牌();
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] ints = y.advantageCount(nums1, nums2);
        int[] expectedResult = {2, 11, 7, 15};

        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test2() {
        优势洗牌 y = new 优势洗牌();
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};

        int[] ints = y.advantageCount(nums1, nums2);
        int[] expectedResult = {24, 32, 8, 12};

        BaseTool.equals(ints, expectedResult);
    }
}
