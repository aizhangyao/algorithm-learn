package com.aiz.leetcode.practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangYao
 * @className 数组大小减半
 * @description https://leetcode.cn/problems/reduce-array-size-to-the-half/description/
 * @date Create in 22:06 2024/12/15
 */
public class 数组大小减半 {
    public static int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Integer[] count = new Integer[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count[index++] = entry.getValue();
        }
        Arrays.sort(count, (o1, o2) -> o2 - o1);
        int sumLen = 0;
        for (int i = 0; i < count.length; i++) {
            sumLen += count[i];
            if (sumLen >= arr.length / 2) {
                return i + 1;
            }
        }
        return 1;
    }

    @Test
    public void test() {
        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        assert minSetSize(arr) == 2;
    }

    @Test
    public void test2() {
        int[] arr = {7, 7, 7, 7, 7, 7};
        assert minSetSize(arr) == 1;
    }

}
