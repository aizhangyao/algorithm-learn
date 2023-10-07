package com.aiz.coding_interviews;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className LCR_192_把字符串转换成整数
 * @description https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/description/?envId=coding-interviews
 * @date Create in 23:08 2023/10/5
 */
public class LCR_192_把字符串转换成整数 {
    public int myAtoi(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = str.length();
        if (length == 0) {
            return 0;
        }
        while (str.charAt(i) == ' ') {
            if (++i == length) {
                return 0;
            }
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        for (int j = i; j < length; j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
            if (res > bndry || res == bndry && str.charAt(j) > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(j) - '0');
        }
        return sign * res;
    }

    @Test
    public void test() {
        assert myAtoi("42") == 42;
    }

    @Test
    public void test2() {
        assert myAtoi("   -42") == -42;
    }

    @Test
    public void test3() {
        assert myAtoi("4193 with words") == 4193;
    }

    @Test
    public void test4() {
        assert myAtoi("words and 987") == 0;
    }

}
