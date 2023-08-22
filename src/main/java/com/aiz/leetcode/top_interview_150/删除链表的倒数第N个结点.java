package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 删除链表的倒数第N个结点
 * @description https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @date Create in 23:56 2023/8/22
 */
public class 删除链表的倒数第N个结点 {
    /**
     * 快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node0.next = node1;
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        ListNode node4 = new ListNode(5);
        node3.next = node4;
        ListNode listNode = removeNthFromEnd(node0, 2);
        System.out.println();
    }

    /**
     * 遍历求长度
     * 栈
     */
}
