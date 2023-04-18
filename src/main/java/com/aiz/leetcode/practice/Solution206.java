package com.aiz.leetcode.practice;

import com.aiz.base.list.ListNode;

/**
 * @ClassName Solution206
 * @Description 反转链表
 * @Author Yao
 * @Date Create in 9:28 下午 2021/9/26
 * @Version 1.0
 */
public class Solution206 {
    /**
     * 我写的
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            // 把head中第一个节点拿出来 放在tail的第一个
            if (tail == null) {
                tail = temp;
                tail.next = null;
            } else {
                temp.next = tail;
                tail = temp;
            }
        }
        return tail;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode init(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node;
    }

    public static void main(String[] args) {
        ListNode node = init();
        ListNode reverseNode = reverseList(node);
        while (reverseNode != null) {
            System.out.print(reverseNode.val + " ");
            reverseNode = reverseNode.next;
        }
    }


}
