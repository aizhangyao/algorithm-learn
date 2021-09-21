package com.aiz.nowcoder.practice;

/**
 * @ClassName NC78
 * @Description 反转链表
 * @Author Yao
 * @Date Create in 9:56 下午 2021/9/19
 * @Version 1.0
 */
public class NC78 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode result = null;
        while (head != null){
            ListNode node = head;
            head = head.next;
            node.next = result;
            result = node;
        }
        return result;
    }

    public static void print(ListNode head) {
        do {
            System.out.print(head.val + " ");
            head = head.next;
        } while (head != null);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        listNode1 = ReverseList(listNode1);
        System.out.println();

    }



    /**
     * 1.取出head的第一个节点node追加到result后
     * 2.head = head.next;
     * 3.设置node到下一个节点为result
     * 4.result指向node
     */
}
