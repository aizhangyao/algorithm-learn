package com.aiz.leetcode.practice;

/**
 * @ClassName Solution2
 * @Description 两数相加
 * @Author Yao
 * @Date Create in 3:33 下午 2021/9/23
 * @Version 1.0
 */
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            int val = sum % 10;
            if (head == null) {
                head = new ListNode(val);
                tail = head;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        // 2 4 3
        // 5 6 4
        // 7 0 8
        ListNode l1 = new ListNode(2);
        ListNode l1_0 = new ListNode(4);
        l1.next = l1_0;
        ListNode l1_1 = new ListNode(3);
        l1_0.next = l1_1;

        ListNode l2 = new ListNode(5);
        ListNode l2_0 = new ListNode(6);
        l2.next = l2_0;
        ListNode l2_1 = new ListNode(4);
        l2_0.next = l2_1;

        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
