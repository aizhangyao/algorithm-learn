package com.aiz.leetcode.top_interview_150;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYao
 * @className 汇总区间
 * @description https://leetcode.cn/problems/summary-ranges/
 * @date Create in 17:22 2023/8/11
 */
public class 汇总区间 {

    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length >= 1) {
            res.add(nums[0] + "");
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                // 与前面的合并
                String s = res.get(res.size() - 1);
                res.remove(s);
                String[] split = s.split("->");
                res.add(split[0] + "->" + nums[i]);
            } else {
                // 大于1
                res.add(nums[i] + "");
            }
        }
        return res;
    }

    /**
     * 我们从数组的位置 0 出发，向右遍历。
     * 每次遇到相邻元素之间的差值大于 1 时，我们就找到了一个区间。
     * 遍历完数组之后，就能得到一系列的区间的列表。
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int a = i;
            i++;
            while (i < nums.length && nums[i - 1] + 1 == nums[i]) {
                i++;
            }
            int b = i - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[a]);
            if (a < b) {
                sb.append("->");
                sb.append(nums[b]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    @Test
    public void test() {
        汇总区间 clazz = new 汇总区间();
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> stringList = clazz.summaryRanges(nums);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("0->2");
        expectedResult.add("4->5");
        expectedResult.add("7");
        BaseTool.equals(stringList, expectedResult);
    }

    @Test
    public void test2() {
        汇总区间 clazz = new 汇总区间();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> stringList = clazz.summaryRanges(nums);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("0");
        expectedResult.add("2->4");
        expectedResult.add("6");
        expectedResult.add("8->9");
        BaseTool.equals(stringList, expectedResult);
    }

    @Test
    public void test3() {
        汇总区间 clazz = new 汇总区间();
        int[] nums = {-2147483648, -2147483647, 2147483647};
        List<String> stringList = clazz.summaryRanges(nums);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("-2147483648->-2147483647");
        expectedResult.add("2147483647");
        BaseTool.equals(stringList, expectedResult);
    }
}
