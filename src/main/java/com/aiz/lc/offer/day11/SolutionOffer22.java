package com.aiz.lc.offer.day11;

/**
 * @author ZhangYao
 * @version 1.0
 * @className SolutionOffer22
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @date Create in 19:29 2023/4/9
 */
public class SolutionOffer22 {
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
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * <p>
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        int num = size - k;
        for (int i = 0; i < num; i++) {
            res = res.next;
        }
        return res;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SolutionOffer22 solutionOffer = new SolutionOffer22();
        ListNode node6 = solutionOffer.new ListNode(6);
        ListNode node5 = solutionOffer.new ListNode(5);
        node5.next = node6;
        ListNode node4 = solutionOffer.new ListNode(4);
        node4.next = node5;
        ListNode node3 = solutionOffer.new ListNode(3);
        node3.next = node4;
        ListNode node2 = solutionOffer.new ListNode(2);
        node2.next = node3;
        ListNode node1 = solutionOffer.new ListNode(1);
        node1.next = node2;

        ListNode kthFromEnd = solutionOffer.getKthFromEnd2(node1, 4);

        System.out.println(kthFromEnd.val);
    }

    /**
     * answer1 : 两次遍历，求长度
     * answer1 : 快慢指针，先让快指针走k步，慢指针再开始走。快指针走到头，慢指针就是第k个。
     */
}
