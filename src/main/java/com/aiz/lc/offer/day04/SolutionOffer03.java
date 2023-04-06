package com.aiz.lc.offer.day04;

import java.util.HashSet;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer03
 * @description 剑指 Offer 03. 数组中重复的数字
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @date Create in 10:12 2023/4/6
 */
public class SolutionOffer03 {

    public int findRepeatNumber(int[] nums) {
        int repeat = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * answer1 : 时间优先，字典
     * answer2 : 空间优先，指针+原地排序数组
     */
}
