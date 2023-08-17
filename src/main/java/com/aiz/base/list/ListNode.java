package com.aiz.base.list;

/**
 * @author Yao
 * @version 1.0
 * @className ListNode
 * @description
 * @date Create in 10:44 下午 2021/9/26
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode init(int[] nums) {
        ListNode result = new ListNode(nums[0]);
        ListNode node = result;
        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            node.next = temp;
            node = node.next;
        }
        return result;
    }

    public static ListNode initCircle(int[] array, int pos) {
        ListNode head = ListNode.init(array);
        ListNode newHead = head, node = null;
        int index = 0;
        while (head.next != null) {
            if (index == pos) {
                node = head;
            }
            head = head.next;
            index++;
        }
        head.next = node;
        return newHead;
    }

    public static void print(ListNode node) {
        ListNode temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode node = ListNode.init(nums);
        print(node);
        print(node);
    }

}
