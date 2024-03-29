package com.aiz.nowcoder.practice;

/**
 * @ClassName NC2
 * @Description 重排链表
 * https://www.nowcoder.com/practice/3d281dc0b3704347846a110bf561ef6b?tpId=196&&tqId=37046&rp=1&ru=/ta/job-code-total&qru=/ta/job-code-total/question-ranking
 * @Author Yao
 * @Date Create in 7:10 下午 2021/9/21
 * @Version 1.0
 */
public class NC2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * L0 -> L1 -> L2 -> ... -> Ln-2 -> Ln-1 -> Ln
     * L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        // 1。找到中间节点 链表断开 3。后半部分逆序 4。交叉拼接
        ListNode mid = middleNode(head);
        ListNode tail = reverseList(mid);
        //
        while (head !=null && tail!= null){
            ListNode headTemp = head.next;
            ListNode tailTemp = tail.next;
            head.next = tail;
            head = headTemp;
            tail.next = head;
            tail = tailTemp;
        }
    }

    // 1->2->3->4->5 null
    // 2->3->4->5 1->null
    // 3->4->5 2->1->null
    // 4->5 3->2->1->null
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        while (tail != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

    public static void main(String[] args) {
        // init data
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        ListNode node = node1;
        //execute method
        reorderList(node);
        //print
        while (node.next != null) {
            System.out.print(node.val);
            node = node.next;
        }

    }

}
