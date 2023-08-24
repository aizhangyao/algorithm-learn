package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 旋转链表
 * @description https://leetcode.cn/problems/rotate-list/description/
 * @date Create in 10:48 2023/8/23
 */
public class 旋转链表 {
    /**
     * 连成环，然后第len-(k%len)前断链，新链表的头是原链表的第len-(k%len)个节点
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        // 计算长度，头尾相连
        int len = 1;
        while (iter.next != null) {
            iter = iter.next;
            len++;
        }
        iter.next = head;
        // 到这里iter指向原链表的尾部，往后走location步，走到新链表的尾部
        int count = 0, location = len - k % len;
        while (count != location) {
            iter = iter.next;
            count++;
        }
        // 到这里iter指向新链表的尾部，然后断链
        ListNode res = iter.next;
        iter.next = null;
        return res;
    }

    @Test
    public void test() {
        ListNode head = ListNode.init(new int[]{1, 2, 3, 4, 5});
        ListNode node = rotateRight(head, 2);
        ListNode expectedResult = ListNode.init(new int[]{4, 5, 1, 2, 3});
        BaseTool.equals(node, expectedResult);
    }

    @Test
    public void test2() {
        ListNode head = ListNode.init(new int[]{0, 1, 2});
        ListNode node = rotateRight(head, 4);
        ListNode expectedResult = ListNode.init(new int[]{2, 0, 1});
        BaseTool.equals(node, expectedResult);
    }
}
