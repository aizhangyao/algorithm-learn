package com.aiz.leetcode.practice;

import com.aiz.base.list.ListNode;

/**
 * @ClassName Solution21
 * @Description 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @Author Yao
 * @Date Create in 5:38 下午 2021/10/1
 * @Version 1.0
 */
public class Solution21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void test1() {
        ListNode l1 = ListNode.init(new int[]{2, 3, 6, 7, 9});
        ListNode l2 = ListNode.init(new int[]{1, 5, 8, 10});
        ListNode node = mergeTwoLists(l1, l2);
        ListNode.print(node);
    }

    public static void test2() {
        ListNode l1 = ListNode.init(new int[]{});
        ListNode l2 = ListNode.init(new int[]{});
        ListNode node = mergeTwoLists(l1, l2);
        ListNode.print(node);
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

}
