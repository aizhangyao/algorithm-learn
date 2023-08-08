package com.aiz.leetcode.top_interview_150;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZhangYao
 * @className 分发糖果
 * @description https://leetcode.cn/problems/candy/
 * @date Create in 10:50 2023/8/8
 */
public class 分发糖果 {

    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        // 从左到右先给【评分单调递增】的小孩发糖
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // 从右到左先给【评分单调递减】的小孩发糖
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }

    @Test
    public void test() {
        分发糖果 clazz = new 分发糖果();
        int[] ratings = new int[]{1, 0, 2};
        int candy = clazz.candy(ratings);
        assert candy == 5;
    }

    @Test
    public void test2() {
        分发糖果 clazz = new 分发糖果();
        int[] ratings = new int[]{1, 2, 2};
        int candy = clazz.candy(ratings);
        assert candy == 4;
    }
}
