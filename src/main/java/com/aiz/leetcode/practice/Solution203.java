package com.aiz.leetcode.practice;

import com.aiz.base.list.ListNode;

/**
 * @ClassName Solution203
 * @Description 移除链表元素
 * @Author Yao
 * @Date Create in 9:56 下午 2021/9/26
 * @Version 1.0
 */
public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode node = ListNode.init(nums);

    }

}
