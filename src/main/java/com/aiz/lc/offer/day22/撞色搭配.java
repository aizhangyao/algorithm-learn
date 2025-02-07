package com.aiz.lc.offer.day22;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author ZhangYao
 * @className 撞色搭配
 * @description 剑指 Offer 56 - 撞色搭配
 * https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @date Create in 17:36 2023/5/8
 */
public class 撞色搭配 {

    // 分组异或
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public int[] sockCollocation(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret ^= num; //ret最终答案就是那两个只出现一次的的数异或的结果
        }
        //找到ret二进制数中第几位是1
        int target = 1;
        while ((target & ret) == 0) { //如果target第一个二进制位不为1，就将target左移一位位0010，然后与相与，判断ret第二位是否为一.按此循环，知道找到ret的第一个为1的二进制位
            target = target << 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((target & num) == 0) {
                // 第一组
                a ^= num;
            } else {
                // 第二组
                b ^= num;
            }
        }
        return new int[]{a, b};
    }


    // 使用set
    public int[] sockCollocation2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }
        }
        Integer[] temp = set.toArray(new Integer[2]);
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            result[i] = temp[i];
        }
        return result;
    }


    @Test
    public void test() {
        int[] sockets = {4, 5, 2, 4, 6, 6};
        int[] result = sockCollocation(sockets);
        int[] expectedResult = {2, 5};
        int[] expectedResult2 = {5, 2};
        assert BaseTool.isEquals(result, expectedResult) || BaseTool.isEquals(result, expectedResult2);
    }

    @Test
    public void test2() {
        int[] sockets = {1, 2, 4, 1, 4, 3, 12, 3};
        int[] result = sockCollocation(sockets);
        int[] expectedResult = {2, 12};
        int[] expectedResult2 = {12, 2};
        assert BaseTool.isEquals(result, expectedResult) || BaseTool.isEquals(result, expectedResult2);
    }
}
