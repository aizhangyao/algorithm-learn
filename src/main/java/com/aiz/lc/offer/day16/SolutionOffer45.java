package com.aiz.lc.offer.day16;

import java.util.Arrays;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer45
 * @description 剑指 Offer 45. 把数组排成最小的数
 * https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @date Create in 23:49 2023/4/17
 */
public class SolutionOffer45 {

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     */
    public String minNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numStrs.length; i++) {
            stringBuilder.append(numStrs[i]);
        }
        return stringBuilder.toString();
    }

    public String minNumber2(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        SolutionOffer45 solutionOffer45 = new SolutionOffer45();
        // 102
        System.out.println(solutionOffer45.minNumber(new int[]{10, 2}));
        // 3033459
        System.out.println(solutionOffer45.minNumber(new int[]{3, 30, 34, 5, 9}));
    }

    /**
     * answer1 : 内置排序
     * answer2 : lambda
     * answer3 : 快排 todo
     */
}
