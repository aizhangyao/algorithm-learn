package com.aiz.coding_interviews;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className LCR_136_删除链表的节点
 * @description https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description/?envId=coding-interviews
 * @date Create in 22:50 2023/10/10
 */
public class LCR_136_删除链表的节点 {
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init(new int[]{4, 5, 1, 9});
        int val = 5;
        ListNode result = deleteNode(head, val);
        ListNode expectedResult = ListNode.init(new int[]{4, 1, 9});
        BaseTool.equals(result, expectedResult);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.init(new int[]{4, 5, 1, 9});
        int val = 1;
        ListNode result = deleteNode(head, val);
        ListNode expectedResult = ListNode.init(new int[]{4, 5, 9});
        BaseTool.equals(result, expectedResult);
    }
}
