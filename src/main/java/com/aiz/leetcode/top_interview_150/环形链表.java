package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 环形链表
 * @description https://leetcode.cn/problems/linked-list-cycle/
 * @date Create in 17:09 2023/8/17
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    @Test
    public void test() {
        环形链表 clazz = new 环形链表();
        ListNode head = ListNode.initCircle(new int[]{3, 2, 0, -4}, 1);
        boolean b = clazz.hasCycle(head);
        assert b;
    }

    @Test
    public void test2() {
        环形链表 clazz = new 环形链表();
        ListNode head = ListNode.initCircle(new int[]{1, 2}, 0);
        boolean b = clazz.hasCycle(head);
        assert b;
    }

    @Test
    public void test3() {
        环形链表 clazz = new 环形链表();
        ListNode head = ListNode.initCircle(new int[]{1}, -1);
        boolean b = clazz.hasCycle(head);
        assert !b;
    }


}
