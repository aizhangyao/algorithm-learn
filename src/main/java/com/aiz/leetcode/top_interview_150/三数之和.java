package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhangYao
 * @className 三数之和
 * @description https://leetcode.cn/problems/3sum/
 * @date Create in 13:41 2023/8/9
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    @Test
    public void test() {
        三数之和 clazz = new 三数之和();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = clazz.threeSum(nums);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(-1);
        list0.add(-1);
        list0.add(2);
        expectedResult.add(list0);
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        list1.add(0);
        list1.add(1);
        expectedResult.add(list1);

        assertList(list, expectedResult);
    }

    @Test
    public void test2() {
        三数之和 clazz = new 三数之和();
        int[] nums = new int[]{-0, 1, 1};
        List<List<Integer>> list = clazz.threeSum(nums);
        List<List<Integer>> expectedResult = new ArrayList<>();
        assertList(list, expectedResult);
    }

    @Test
    public void test3() {
        三数之和 clazz = new 三数之和();
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> list = clazz.threeSum(nums);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(0);
        list0.add(0);
        list0.add(0);
        expectedResult.add(list0);
        assertList(list, expectedResult);
    }

    @Test
    public void test4() {
        三数之和 clazz = new 三数之和();
        int[] nums = new int[]{0, 0, 0, 0};
        List<List<Integer>> list = clazz.threeSum(nums);
        List<List<Integer>> expectedResult = new ArrayList<>();
        List<Integer> list0 = new ArrayList<>();
        list0.add(0);
        list0.add(0);
        list0.add(0);
        expectedResult.add(list0);
        assertList(list, expectedResult);
    }

    private void assertList(List<List<Integer>> list, List<List<Integer>> expectedResult) {
        assert list.size() == expectedResult.size();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> listTemp = list.get(i);
            List<Integer> expectedResultTemp = expectedResult.get(i);
            assert listTemp.size() == expectedResultTemp.size();
            for (int j = 0; j < list.size(); j++) {
                assert Objects.equals(listTemp.get(j), expectedResultTemp.get(j));
            }
        }
    }
}
