package com.aiz.leetcode.top_interview_150;

import com.aiz.base.list.ListNode;

/**
 * @author ZhangYao
 * @className 合并两个有序链表
 * @description https://leetcode.cn/problems/merge-two-sorted-lists/
 * @date Create in 17:58 2023/8/17
 */
public class 合并两个有序链表 {
    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }

}
