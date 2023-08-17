package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;
import com.aiz.base.util.BaseTool;
import org.junit.jupiter.api.Test;

/**
 * @author ZhangYao
 * @className 两数相加
 * @description https://leetcode.cn/problems/add-two-numbers/
 * @date Create in 17:31 2023/8/17
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pre = new ListNode();
        ListNode head = pre;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            head.next = new ListNode(val % 10);
            head = head.next;
            carry = val / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            head.next = new ListNode(val % 10);
            carry = val / 10;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + carry;
            head.next = new ListNode(val % 10);
            carry = val / 10;
            head = head.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            head.next = new ListNode(carry);
        }
        return pre.next;
    }

    @Test
    public void test() {
        两数相加 clazz = new 两数相加();
        ListNode l1 = ListNode.init(new int[]{2, 4, 3});
        ListNode l2 = ListNode.init(new int[]{5, 6, 4});
        ListNode listNode = clazz.addTwoNumbers(l1, l2);
        ListNode expectedResult = ListNode.init(new int[]{7, 0, 8});
        BaseTool.equals(listNode, expectedResult);
    }

    @Test
    public void test2() {
        两数相加 clazz = new 两数相加();
        ListNode l1 = ListNode.init(new int[]{0});
        ListNode l2 = ListNode.init(new int[]{0});
        ListNode listNode = clazz.addTwoNumbers(l1, l2);
        ListNode expectedResult = ListNode.init(new int[]{0});
        BaseTool.equals(listNode, expectedResult);
    }

    @Test
    public void test3() {
        两数相加 clazz = new 两数相加();
        ListNode l1 = ListNode.init(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.init(new int[]{9, 9, 9, 9});
        ListNode listNode = clazz.addTwoNumbers(l1, l2);
        ListNode expectedResult = ListNode.init(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        BaseTool.equals(listNode, expectedResult);
    }
}
