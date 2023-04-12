package com.aiz.lc.offer.day12;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer52
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @date Create in 00:13 2023/4/11
 */
public class SolutionOffer52 {
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

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     * <p>
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }

    /**
     * 两个结点不断的去对方的轨迹中寻找对方的身影，只要二人有交集，就终会相遇。
     * answer1 : 双指针
     */
}
