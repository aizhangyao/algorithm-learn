package com.aiz.coding_interviews;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className LCR_122_路径加密
 * @description https://leetcode.cn/problems/ti-huan-kong-ge-lcof/description/envId=coding-interviews
 * @date Create in 22:17 2023/10/1
 */
public class LCR_122_路径加密 {
    public String pathEncryption(String path) {
        return path.replace(".", " ");
    }

    public String pathEncryption2(String path) {
        StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == '.') {
                sb.append(' ');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assert pathEncryption2("a.aef.qerf.bb").equals("a aef qerf bb");
    }
}
