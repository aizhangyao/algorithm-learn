package com.aiz.coding_interviews;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className LCR_141_训练计划III
 * @description https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/description/?envId=coding-interviews
 * @date Create in 23:21 2023/10/8
 */
public class LCR_141_训练计划III {
    public ListNode trainningPlan(ListNode head) {
        // 不断取cur的头部节点，放在res头部
        ListNode res = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = res;
            res = cur;
            cur = next;
        }
        return res;
    }

    @Test
    public void test() {
        ListNode listNode = trainningPlan(ListNode.init(new int[]{1, 2, 3, 4, 5}));
        BaseTool.equals(listNode, ListNode.init(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void test2() {
        ListNode listNode = trainningPlan(ListNode.init(new int[]{1, 2}));
        BaseTool.equals(listNode, ListNode.init(new int[]{2, 1}));
    }
}
