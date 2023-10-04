package com.aiz.coding_interviews;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author ZhangYao
 * @className LCR_182_动态口令
 * @description https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/description/?envId=coding-interviews
 * @date Create in 22:45 2023/10/4
 */
public class LCR_182_动态口令 {
    public String dynamicPassword(String password, int target) {
        char[] chars = password.toCharArray();
        reverse(chars, 0, password.length() - 1);
        reverse(chars, 0, password.length() - target - 1);
        reverse(chars, password.length() - target, password.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        String r1tyC0d3s3cu = dynamicPassword("s3cur1tyC0d3", 4);
        assert Objects.equals(r1tyC0d3s3cu, "r1tyC0d3s3cu");
    }

    @Test
    public void test2() {
        String umghlrlose = dynamicPassword("lrloseumgh", 6);
        assert Objects.equals(umghlrlose, "umghlrlose");
    }

}
