package com.aiz.lc.offer.day02;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer24
 * @description 剑指 Offer 24. 反转链表
 * https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
 * @date Create in 10:15 2023/4/5
 */
public class SolutionOffer24 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }

}
