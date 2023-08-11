package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangYao
 * @className H指数
 * @description https://leetcode.cn/problems/h-index/
 * @date Create in 17:31 2023/8/7
 */
public class H指数 {
    public int hIndex(int[] citations) {
        // 排序
        Arrays.sort(citations);
        int hNum = 0;
        // citations.length 5
        // i 4
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] < citations.length - i) {
                break;
            }
            hNum++;
        }
        return hNum;
    }

    @Test
    public void test() {
        H指数 clazz = new H指数();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        // 6,5,3,1,0
        int i = clazz.hIndex(citations);
        assert i == 3;
    }

    @Test
    public void test2() {
        H指数 clazz = new H指数();
        int[] citations = new int[]{1, 3, 1};
        int i = clazz.hIndex(citations);
        assert i == 1;
    }
}
