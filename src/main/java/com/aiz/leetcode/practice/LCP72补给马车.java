package com.aiz.leetcode.practice;

import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhangYao
 * @className LCP72补给马车
 * @description https://leetcode.cn/problems/hqCnmP/description/
 * @date Create in 16:21 2024/3/28
 */
public class LCP72补给马车 {

    public int[] supplyWagon(int[] supplies) {
        if (supplies == null || supplies.length < 2) {
            return supplies;
        }
        int len = supplies.length / 2;
        List<Integer> list = Arrays.stream(supplies).boxed().collect(Collectors.toList());
        while (list.size() > len) {
            int minIdx = 0;
            int min = list.get(0) + list.get(1);
            for (int i = 1; i < list.size() - 1; i++) {
                int now = list.get(i) + list.get(i + 1);
                if (now < min) {
                    min = now;
                    minIdx = i;
                }
            }
            list.set(minIdx, min);
            list.remove(minIdx + 1);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    @Test
    public void test() {
        LCP72补给马车 y = new LCP72补给马车();
        int[] supplies = {7, 3, 6, 1, 8};
        int[] ints = y.supplyWagon(supplies);
        int[] expectedResult = {10, 15};

        BaseTool.equals(ints, expectedResult);
    }

    @Test
    public void test2() {
        LCP72补给马车 y = new LCP72补给马车();
        int[] supplies = {1, 3, 1, 5};
        int[] ints = y.supplyWagon(supplies);
        int[] expectedResult = {5, 5};

        BaseTool.equals(ints, expectedResult);
    }
}
