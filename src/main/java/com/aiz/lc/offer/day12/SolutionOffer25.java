package com.aiz.lc.offer.day12;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer25
 * @description 剑指 Offer 25. 合并两个排序的链表
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @date Create in 23:49 2023/4/10
 */
public class SolutionOffer25 {
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
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return head.next;
    }


    /**
     * answer1 : 链表 迭代
     * answer2 : 递归 todo
     */
}
